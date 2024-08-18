package baekjoon.knapsack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G3_07579_앱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            memory[i] = Integer.parseInt(st.nextToken());

        int totalCost = 0;
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            totalCost += cost[i];
        }

        int[] dp = new int[totalCost + 1];
        for (int i = 0; i < N; i++) {
            for (int c = totalCost; c >= cost[i] ; c--) {
                dp[c] = Math.max(dp[c], dp[c - cost[i]] + memory[i]);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int c = 0; c < totalCost + 1; c++) {
            if (dp[c] >= M)
                answer = Math.min(answer, c);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
