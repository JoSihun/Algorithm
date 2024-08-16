package baekjoon.dp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G3_02342_DanceDanceRevolution {
    public static int cost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> commands = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int command = Integer.parseInt(st.nextToken());
            if (command == 0) break;
            commands.add(command);
        }

        int N = commands.size();
        int[][][] dp = new int[N + 1][5][5];
        for (int i = 0; i < N + 1; i++)
            for (int l = 0; l < 5; l++)
                for (int r = 0; r < 5; r++)
                    dp[i][r][l] = Integer.MAX_VALUE / 5;

        dp[0][0][0] = 0;
        for (int i = 1; i < N + 1; i++) {
            int command = commands.get(i - 1);
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    dp[i][command][r] = Math.min(dp[i][command][r], dp[i - 1][l][r] + cost(l, command));
                    dp[i][l][command] = Math.min(dp[i][l][command], dp[i - 1][l][r] + cost(r, command));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int l = 0; l < 5; l++)
            for (int r = 0; r < 5; r++)
                answer = Math.min(answer, dp[N][l][r]);

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
