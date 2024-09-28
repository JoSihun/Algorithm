package baekjoon.union_find;

import java.io.*;
import java.util.StringTokenizer;

public class Main_P3_03830_교수님은기다리지않는다 {
    public static int N, M;
    public static int[] weight;
    public static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) return x;
        int rootX = find(parent[x]);
        weight[x] += weight[parent[x]];
        return parent[x] = rootX;
    }

    public static void union(int a, int b, int w) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        parent[rootB] = rootA;
        weight[rootB] = weight[a] - weight[b] + w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            weight = new int[N + 1];
            parent = new int[N + 1];
            for (int i = 0; i < N + 1; i++)
                parent[i] = i;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if (command.equals("!")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                } else if (command.equals("?")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    if (find(a) != find(b)) {
                        sb.append("UNKNOWN").append("\n");
                    } else {
                        sb.append(weight[b] - weight[a]).append("\n");
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
