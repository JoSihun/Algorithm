package baekjoon.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_G3_16724_피리부는사나이 {
    public static int N, M;
    public static int[] parent;

    public static char[][] map;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static Map<Character, Integer> directions;

    public static void make() {
        parent = new int[N * M];
        for (int i = 0; i < N * M; i++)
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
        parent[rootY] = rootX;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        directions = new HashMap<>();
        directions.put('U', 0);
        directions.put('D', 1);
        directions.put('L', 2);
        directions.put('R', 3);
        make();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                int d = directions.get(map[x][y]);
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M)
                    union(x * M + y, nx * M + ny);
            }
        }

        int answer = 0;
        for (int i = 0; i < N * M; i++)
            if (find(i) == i) answer++;
        System.out.println(answer);
    }
}
