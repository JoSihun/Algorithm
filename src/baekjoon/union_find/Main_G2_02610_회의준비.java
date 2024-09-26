package baekjoon.union_find;

import java.io.*;
import java.util.*;

public class Main_G2_02610_회의준비 {
    public static int N, M;
    public static int[] parent;
    public static int[][] dist;

    public static void make() {
        parent = new int[N + 1];
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
        if (rootX == rootY) return;
        parent[rootX] = rootY;
    }

    public static void floydWarshall() {
        for (int k = 1; k < N + 1; k++)
            for (int i = 1; i < N + 1; i++)
                for (int j = 1; j < N + 1; j++)
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++)
            for (int j = 0; j < N + 1; j++)
                if (i != j) dist[i][j] = Integer.MAX_VALUE;

        make();
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = dist[b][a] = 1;
            union(a, b);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            int root = find(i);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(i);
        }

        floydWarshall();
        List<Integer> answer = new ArrayList<>();
        for (List<Integer> group : groups.values()) {
            int min = Integer.MAX_VALUE;
            int representative = -1;

            for (int member : group) {
                int max = Integer.MIN_VALUE;
                for (int other : group)
                    if (dist[member][other] < Integer.MAX_VALUE)
                        max = Math.max(max, dist[member][other]);

                if (max < min) {
                    min = max;
                    representative = member;
                }
            }
            answer.add(representative);
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int representative : answer)
            sb.append(representative).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
