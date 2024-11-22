package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_28281_선물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            dp[i] = Integer.parseInt(st.nextToken());

        long answer = dp[0] + dp[1];
        for (int i = 1; i < N - 1; i++)
            answer = Math.min(answer, dp[i] + dp[i + 1]);
        System.out.println(answer * X);
    }
}
