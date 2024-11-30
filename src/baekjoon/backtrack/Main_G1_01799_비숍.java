package baekjoon.backtrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/1799 */
public class Main_G1_01799_비숍 {
    public static int N;
    public static int[][] board;
    public static boolean[] diag1, diag2; // 대각선 점유 상태 체크
    public static int maxBlack, maxWhite;

    public static void backtrack(int row, int col, int count, boolean isBlack) {
        // 한 행이 끝났을 때
        if (col >= N) {
            col = (col % 2 == 0) ? 1 : 0;
            row++;
        }

        // 체스판을 모두 탐색한 경우
        if (row == N) {
            if (isBlack) {
                maxBlack = Math.max(maxBlack, count);
            } else {
                maxWhite = Math.max(maxWhite, count);
            }
            return;
        }

        // 현재 칸에 비숍을 놓는 경우
        if (board[row][col] == 1 && !diag1[row - col + N] && !diag2[row + col]) {
            diag1[row - col + N] = true; diag2[row + col] = true;
            backtrack(row, col + 2, count + 1, isBlack);
            diag1[row - col + N] = false; diag2[row + col] = false;
        }

        // 현재 칸에 비숍을 놓지 않는 경우
        backtrack(row, col + 2, count, isBlack);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        diag1 = new boolean[2 * N]; // \ 대각선 점유 체크
        diag2 = new boolean[2 * N]; // / 대각선 점유 체크
        backtrack(0, 0, 0, true);   // 흑 칸 백트래킹
        backtrack(0, 1, 0, false);  // 백 칸 백트래킹
        System.out.println(maxBlack + maxWhite);
    }
}
