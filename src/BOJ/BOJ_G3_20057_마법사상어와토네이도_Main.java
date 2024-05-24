package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G3_20057_마법사상어와토네이도_Main {
    private static int N, answer;
    private static int[][] map;
    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { -1, 0, 1, 0 };

    private static void simulate(int x, int y, int d) {
        int length = 1;

        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < length; j++) {
                    x = x + dx[d];
                    y = y + dy[d];
                    spread(x, y, d);
                    if (x == 0 && y == 0)
                        return;
                }
                d = (d + 1) % 4;
            }
            length++;
        }
    }

    private static int[] spreadRatio = { 5, 10, 10, 7, 7, 2, 2, 1, 1 };
    private static int[][] spreadDx = {
            { 0, 1, -1, 1, -1, 2, -2, 1, -1 },
            { 2, 1, 1, 0, 0, 0, 0, -1, -1 },
            { 0, 1, -1, 1, -1, 2, -2, 1, -1 },
            { -2, -1, -1, 0, 0, 0, 0, 1, 1 },
    };
    private static int[][] spreadDy = {
            { -2, -1, -1, 0, 0, 0, 0, 1, 1 },
            { 0, -1, 1, -1, 1, -2, 2, -1, 1 },
            { 2, 1, 1, 0, 0, 0, 0, -1, -1 },
            { 0, -1, 1, -1, 1, -2, 2, -1, 1 },
    };

    private static void spread(int x, int y, int d) {
        int baseAmount = map[x][y];
        int scatteredAmount = 0;

        for (int i = 0; i < 9; i++) {
            int nx = x + spreadDx[d][i];
            int ny = y + spreadDy[d][i];
            int spreadAmount = (baseAmount * spreadRatio[i]) / 100;

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                map[nx][ny] += spreadAmount;
            } else answer += spreadAmount;
            scatteredAmount += spreadAmount;
        }

        int alphaX = x + dx[d];
        int alphaY = y + dy[d];
        int spreadAmount = baseAmount - scatteredAmount;
        if (0 <= alphaX && alphaX < N && 0 <= alphaY && alphaY < N) {
            map[alphaX][alphaY] += spreadAmount;
        } else answer += spreadAmount;
        map[x][y] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate(N / 2, N / 2, 0);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
