package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_02156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            wine[i] = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = wine[1]; dp[2] = wine[1] + wine[2];
        for (int i = 3; i < N + 1; i++)
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wine[i]), dp[i - 3] + wine[i - 1] + wine[i]);
        System.out.println(dp[N]);
    }
}
