package baekjoon.union_find;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_01976_여행가자 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        make();
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int isConnect = Integer.parseInt(st.nextToken());
                if (isConnect == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int rootA = find(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < M - 1; i++) {
            if (rootA != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
