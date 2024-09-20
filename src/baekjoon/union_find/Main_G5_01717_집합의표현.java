package baekjoon.union_find;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_01717_집합의표현 {
    public static int N, M;
    public static int[] rank;
    public static int[] parent;

    public static void make() {
        rank = new int[N + 1];
        parent = new int[N + 1];

        Arrays.fill(rank, 1);
        for (int i = 0; i < N + 1; i++)
            parent[i] = i;
    }

    // return 경로 압축 최적화
    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        
        // 랭크(rank)가 더 높은 집합이 루트가 됨
        if (rank[rootA] > rank[rootB])
            parent[rootB] = rootA;
        else if (rank[rootA] < rank[rootB])
            parent[rootA] = rootB;
        else {                      // rank 가 같으면
            parent[rootB] = rootA;  // rootA를 루트로 만들고
            rank[rootA]++;          // rootA의 랭크 상승
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        make();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0)
                union(a, b);
            else if (command == 1)
                sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
