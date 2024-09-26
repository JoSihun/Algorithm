package baekjoon.union_find;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_10216_CountCircleGroups {
    public static int N;
    public static int[] rank;
    public static int[] parent;

    public static void make() {
        rank = new int[N];
        parent = new int[N];
        Arrays.fill(rank, 1);
        for (int i = 0; i < N; i++)
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

    public static boolean isAvailable(int[] circle1, int[] circle2) {
        int x1 = circle1[0], y1 = circle1[1], r1 = circle1[2];
        int x2 = circle2[0], y2 = circle2[1], r2 = circle2[2];
        int distCenter = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        int distRadius = (r1 + r2) * (r1 + r2);
        return distCenter <= distRadius;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            int[][] circles = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                circles[i][0] = Integer.parseInt(st.nextToken());   // x
                circles[i][1] = Integer.parseInt(st.nextToken());   // y
                circles[i][2] = Integer.parseInt(st.nextToken());   // R
            }

            make();
            for (int i = 0; i < N - 1; i++)
                for (int j = i + 1; j < N; j++)
                    if (isAvailable(circles[i], circles[j]))
                        union(i, j);

            int answer = 0;
            for (int i = 0; i < N; i++)
                if (find(i) == i) answer++;
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
