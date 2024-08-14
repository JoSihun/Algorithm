package baekjoon.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_17404_RGB거리2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];
            Arrays.fill(dp[0], Integer.MAX_VALUE / 5);

            dp[0][firstColor] = cost[0][firstColor];
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++)
                if (lastColor != firstColor)
                    answer = Math.min(answer, dp[N - 1][lastColor]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
