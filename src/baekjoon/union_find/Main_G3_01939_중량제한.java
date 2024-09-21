package baekjoon.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G3_01939_중량제한 {
    public static class Bridge implements Comparable<Bridge> {
        public int from, to, weight;

        public Bridge(int from, int to, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Bridge o) {
            return o.weight - this.weight;
        }
    }

    public static int N, M;
    public static int[] rank;
    public static int[] parent;
    public static List<Bridge> bridges;

    public static void make() {
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

    static int solve(int a, int b) {
        for (Bridge bridge : bridges) {
            union(bridge.from, bridge.to);
            if (find(a) == find(b))
                return bridge.weight;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rank = new int[N + 1];
        parent = new int[N + 1];
        make();

        bridges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            bridges.add(new Bridge(A, B, C));
        }
        Collections.sort(bridges);

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(solve(A, B));
    }
}
