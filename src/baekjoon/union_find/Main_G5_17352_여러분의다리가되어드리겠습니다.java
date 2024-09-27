package baekjoon.union_find;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G5_17352_여러분의다리가되어드리겠습니다 {
    public static int N;
    public static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        parent[rootX] = rootY;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++)
            parent[i] = i;

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int rootA = find(1), rootB = find(1);
        for (int i = 2; i < N + 1 && rootA == rootB; i++)
            rootB = find(i);
        System.out.println(rootA + " " + rootB);
    }
}
