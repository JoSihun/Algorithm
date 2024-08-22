package baekjoon.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G1_02098_외판원순회 {
    public static final int INF = 16_000_000;

    public static int N;
    public static int[][] W;
    public static int[][] dp;

    public static int tsp(int current, int visited) {
        if (visited == (1 << N) - 1)
            return W[current][0] == 0 ? INF : W[current][0];

        if (dp[current][visited] != -1)
            return dp[current][visited];

        int minCost = INF;
        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && W[current][next] != 0)
                minCost = Math.min(minCost, tsp(next, visited | (1 << next)) + W[current][next]);
        }

        return dp[current][visited] = minCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);

        bw.write(String.valueOf(tsp(0, 1)));
        bw.flush();
    }
}
