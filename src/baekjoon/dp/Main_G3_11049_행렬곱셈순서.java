package baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G3_11049_행렬곱셈순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());    // r
            matrix[i][1] = Integer.parseInt(st.nextToken());    // c
        }

        int[][] dp = new int[N][N];
        for (int size = 1; size < N; size++) {
            for (int s = 0; s < N - size; s++) {
                int e = s + size;
                dp[s][e] = Integer.MAX_VALUE;
                for (int k = s; k < e; k++) {
                    int newCost = dp[s][k] + dp[k + 1][e] + matrix[s][0] * matrix[k][1] * matrix[e][1];
                    dp[s][e] = Math.min(dp[s][e], newCost);
                }
            }
        }

        bw.write(String.valueOf(dp[0][N - 1]));
        bw.flush();
    }
}
