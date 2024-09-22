package baekjoon.union_find;

import java.io.*;
import java.util.*;

public class Main_P5_03197_백조의호수 {
    public static int R, C;
    public static int[] rank;
    public static int[] parent;

    public static int[] swan;
    public static char[][] map;
    public static Queue<int[]> queue, temp;
    public static int[] dr = { -1, 1, 0, 0 };
    public static int[] dc = { 0, 0, -1, 1 };

    public static void make() {
        rank = new int[R * C];
        parent = new int[R * C];
        Arrays.fill(rank, 1);
        for (int i = 0; i < R * C; i++)
            parent[i] = i;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static void unionWater(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (0 <= nr && nr < R && 0 <= nc && nc < C)
                if (map[nr][nc] != 'X')
                    union(r * C + c, nr * C + nc);
        }
    }

    public static void meltIce() {
        int size = queue.size();
        while (size-- > 0) {
            int r = queue.peek()[0];
            int c = queue.poll()[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (map[nr][nc] == 'X') {
                        map[nr][nc] = '.';
                        unionWater(nr, nc);
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int cntSwans = 0;
        swan = new int[2];

        map = new char[R][C];
        queue = new ArrayDeque<>();
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                if (map[r][c] != 'X')
                    queue.offer(new int[] { r, c });
                if (map[r][c] == 'L')
                    swan[cntSwans++] = r * C + c;
            }
        }

        make();
        temp = new ArrayDeque<>(queue);
        while (!queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.poll()[1];
            unionWater(r, c);
        }

        int answer = 0;
        queue = new ArrayDeque<>(temp);
        while (find(swan[0]) != find(swan[1])) {
            answer++;
            meltIce();
        }
        System.out.println(answer);
    }
}
