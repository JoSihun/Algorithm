package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Main_G1_13460_구슬탈출2 {
    public static int N, M, answer;
    public static char[][] board;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static int bfs(int redSx, int redSy, int blueSx, int blueSy) {
        boolean[][][][] visited = new boolean[N][M][N][M];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{ redSx, redSy, blueSx, blueSy, 0 });
        visited[redSx][redSy][blueSx][blueSy] = true;

        while (!queue.isEmpty()) {
            int redX = queue.peek()[0];
            int redY = queue.peek()[1];
            int blueX = queue.peek()[2];
            int blueY = queue.peek()[3];
            int count = queue.poll()[4];

            if (count > 10) return -1;
            for (int dir = 0; dir < 4; dir++) {
                int[] next = move(dir, redX, redY, blueX, blueY);
                int redNx = next[0], redNy = next[1];
                int blueNx = next[2], blueNy = next[3];
                int redCount = next[4], blueCount = next[5];

                if (board[blueNx][blueNy] == 'O') continue;
                if (board[redNx][redNy] == 'O')
                    return count + 1 > 10 ? -1 : count + 1;

                if (redNx == blueNx && redNy == blueNy) {
                    if (redCount > blueCount) {
                        redNx -= dx[dir];
                        redNy -= dy[dir];
                    } else {
                        blueNx -= dx[dir];
                        blueNy -= dy[dir];
                    }
                }

                if (!visited[redNx][redNy][blueNx][blueNy]) {
                    visited[redNx][redNy][blueNx][blueNy] = true;
                    queue.offer(new int[]{ redNx, redNy, blueNx, blueNy, count + 1 });
                }
            }
        }

        return -1;
    }

    public static int[] move(int dir, int redX, int redY, int blueX, int blueY) {
        int redCount = 0, blueCount = 0;
        while (board[redX + dx[dir]][redY + dy[dir]] != '#' && board[redX][redY] != 'O') {
            redX += dx[dir];
            redY += dy[dir];
            redCount++;
        }
        while (board[blueX + dx[dir]][blueY + dy[dir]] != '#' && board[blueX][blueY] != 'O') {
            blueX += dx[dir];
            blueY += dy[dir];
            blueCount++;
        }
        return new int[] { redX, redY, blueX, blueY, redCount, blueCount };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'R') { redX = i; redY = j; }
                if (board[i][j] == 'B') { blueX = i; blueY = j; }
            }
        }

        answer = bfs(redX, redY, blueX, blueY);
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
