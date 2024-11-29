package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_G1_01509_펠린드롬분할 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();

        boolean[][] isPalindrome = new boolean[N][N];
        for (int i = 0; i < N; i++)
            isPalindrome[i][i] = true;

        for (int len = 2; len <= N; len++) {
            for (int s = 0; s <= N - len; s++) {
                int e = s + len - 1;
                if (input.charAt(s) == input.charAt(e))
                    isPalindrome[s][e] = (len == 2 || isPalindrome[s + 1][e - 1]);
            }
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int s = 0; s < N; s++) {
            if (isPalindrome[0][s]) {
                dp[s] = 1;
                continue;
            }
            for (int e = 0; e < s; e++) {
                if (isPalindrome[e + 1][s])
                    dp[s] = Math.min(dp[s], dp[e] + 1);
            }
        }
        System.out.println(dp[N - 1]);
    }
}
