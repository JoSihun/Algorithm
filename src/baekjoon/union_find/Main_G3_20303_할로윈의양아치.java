package baekjoon.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G3_20303_할로윈의양아치 {
    public static int N, M, K;
    public static int[] size;
    public static int[] candy;
    public static int[] parent;

    public static class Group {
        public int size, candy;

        public Group(int size, int candy) {
            this.size = size;
            this.candy = candy;
        }
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
        size[rootY] += size[rootX];
        candy[rootY] += candy[rootX];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        size = new int[N + 1];
        candy = new int[N + 1];
        parent = new int[N + 1];

        Arrays.fill(size, 1);
        for (int i = 0; i < N + 1; i++)
            parent[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            candy[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        List<Group> groups = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (i != find(i)) continue;
            groups.add(new Group(size[i], candy[i]));
        }

        int[] dp = new int[K];
        for (Group group : groups)
            for (int k = K - 1; k >= group.size; k--)
                dp[k] = Math.max(dp[k], dp[k - group.size] + group.candy);
        System.out.println(dp[K - 1]);
    }
}
