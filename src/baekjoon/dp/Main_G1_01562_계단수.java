package baekjoon.dp;

import java.io.*;

public class Main_G1_01562_계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int MOD = 1000000000;

        int[][][] dp = new int[N + 1][10][1 << 10];
        for (int i = 1; i <= 9; i++)
            dp[1][i][1 << i] = 1;

        for (int size = 2; size < N + 1; size++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int bitmask = 0; bitmask < (1 << 10); bitmask++) {
                    int curBitMask = bitmask | (1 << digit);

                    if (digit > 0) dp[size][digit][curBitMask] = (dp[size][digit][curBitMask] +
                            dp[size - 1][digit - 1][bitmask]) % MOD;
                    if (digit < 9) dp[size][digit][curBitMask] = (dp[size][digit][curBitMask] +
                            dp[size - 1][digit + 1][bitmask]) % MOD;
                }
            }
        }
        
        int answer = 0;
        for (int digit = 0; digit <= 9; digit++)
            answer = (answer + dp[N][digit][(1 << 10) - 1]) % MOD;

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
