package baekjoon.union_find;

import java.io.*;

public class Main_G2_10775_공항 {
    public static int G, P;
    public static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootMax = find(Math.max(x, y));
        int rootMin = find(Math.min(x, y));
        parent[rootMax] = rootMin;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        for (int i = 0; i < G + 1; i++)
            parent[i] = i;

        int answer = 0;
        for (int i = 0; i < P; i++) {
            int maxGate = Integer.parseInt(br.readLine());
            int availableGate = find(maxGate);

            if (availableGate == 0) break;
            union(availableGate - 1, availableGate);
            answer++;
        }
        System.out.println(answer);
    }
}
