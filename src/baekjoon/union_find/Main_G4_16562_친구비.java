package baekjoon.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_16562_친구비 {
    public static int N, M, K;
    public static int[] cost;
    public static int[] parent;

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

        // 친구비가 더 작은 사람을 대표로 설정
        if (cost[rootX] < cost[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cost = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        make();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int answer = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            int root = find(i);
            if (!visited[root]) {
                answer += cost[root];
                visited[root] = true;
            }
        }
        System.out.println(answer <= K ? answer : "Oh no");
    }
}
