package baekjoon.union_find;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_04803_트리 {
    public static int N, M;
    public static int[] rank;
    public static int[] parent;
    public static boolean[] isCycle;

    public static void make() {
        rank = new int[N + 1];
        parent = new int[N + 1];
        Arrays.fill(rank, 1);
        for (int i = 0; i < N + 1; i++)
            parent[i] = i;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            isCycle[rootX] = true;
            return;
        }

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            make();
            isCycle = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            int T = 0;
            for (int i = 1; i < N + 1; i++)
                if (find(i) == i && !isCycle[i]) T++;

            sb.append("Case ").append(tc++);
            if (T == 0) sb.append(": No trees.").append("\n");
            else if (T == 1) sb.append(": There is one tree.").append("\n");
            else sb.append(": A forest of ").append(T).append(" trees.").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
