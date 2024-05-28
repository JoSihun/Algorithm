package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B2_01965_상자넣기_Main {
    private static int N, answer;
    private static int[] box, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        box = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            box[i] = Integer.parseInt(st.nextToken());

        answer = 0;
        dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (box[j] < box[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(dp[i], answer);
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
