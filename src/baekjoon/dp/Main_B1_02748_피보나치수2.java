package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_02748_피보나치수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0 || N == 1) {
            System.out.println(N);
            return;
        }

        long[] dp = new long[N + 1];
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i < N + 1; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        System.out.println(dp[N]);
    }
}
