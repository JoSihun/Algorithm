package baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G4_10942_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[N + 1][N + 1];

        // 길이가 1인 펠린드롬
        for (int i = 1; i < N + 1; i++)
            dp[i][i] = true;

        // 길이가 2인 펠린드롬
        for (int i = 1; i < N; i++)
            if (numbers[i] == numbers[i + 1])
                dp[i][i + 1] = true;

        // 길이가 3 이상인 펠린드롬
        for (int size = 3; size < N + 1; size++) {
            for (int s = 1; s <= N - size + 1; s++) {
                int e = s + size - 1;
                if (numbers[s] == numbers[e]) {
                    if (dp[s + 1][e - 1])
                        dp[s][e] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
