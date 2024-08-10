package baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B2_01890_점프 {
    private static int N;
    private static int[][] map;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N][N];
        dp[0][0] = 1;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // 종료 종건
                if (x == N - 1 && y == N - 1) break;
                // 이동이 불가능한 경우
                if (map[x][y] == 0) continue;
                // 아래쪽으로 점프하는 경우
                if (x + map[x][y] < N) dp[x + map[x][y]][y] += dp[x][y];
                // 오른쪽으로 점프하는 경우
                if (y + map[x][y] < N) dp[x][y + map[x][y]] += dp[x][y];
            }
        }

        sb.append(dp[N - 1][N - 1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
