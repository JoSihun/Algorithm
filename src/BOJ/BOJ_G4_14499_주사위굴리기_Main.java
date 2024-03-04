package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G4_14499_주사위굴리기_Main {
    private static int N, M, K, x, y;
    private static int[] dice;

    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void move(int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < 0 || nx >= M || ny < 0 || ny >= N) return;
        roll(nx, ny, d);
        x = nx; y = ny;
    }

    public static void roll(int x, int y, int d) {
        int temp = dice[0];

        switch (d) {
            case 0:
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 1:
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            case 3:
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
        }

        if (map[y][x] == 0) {
            map[y][x] = dice[5];
        } else {
            dice[5] = map[y][x];
            map[y][x] = 0;
        }
        System.out.println(dice[0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            move(Integer.parseInt(st.nextToken()) - 1);
    }
}
