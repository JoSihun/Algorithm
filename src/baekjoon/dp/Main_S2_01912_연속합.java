package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_01912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            dp[i] = Integer.parseInt(st.nextToken());

        int sum = dp[0], max = dp[0];
        for (int i = 1; i < N; i++) {
            sum = Math.max(dp[i], sum + dp[i]);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
