package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S1_10844_쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for (int len = 2; len < N + 1; len++) {
            int prev = (len - 1) % 2;
            int curr = len % 2;

            for (int num = 0; num <= 9; num++) {
                dp[curr][num] = 0;
                if (num > 0) {
                    dp[curr][num] += dp[prev][num - 1];
                    dp[curr][num] %= 1_000_000_000;
                }
                if (num < 9) {
                    dp[curr][num] += dp[prev][num + 1];
                    dp[curr][num] %= 1_000_000_000;
                }
            }
        }

        int answer = 0;
        for (int num = 0; num <= 9; num++)
            answer = (answer + dp[N % 2][num]) % 1_000_000_000;
        System.out.println(answer);
    }
}
