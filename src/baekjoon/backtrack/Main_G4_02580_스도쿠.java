package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G4_02580_스도쿠 {
    public static int[][] board;
    public static boolean[][] checkRow;
    public static boolean[][] checkCol;
    public static boolean[][] checkBox;

    public static boolean backtrack(int row, int col) {
        if (col == 9) {
            row++; col = 0;
        }
        if (row == 9) {
            return true;
        }

        if (board[row][col] != 0)
            return backtrack(row, col + 1);

        int box = getBoxIndex(row, col);
        for (int num = 1; num <= 9; num++) {
            if (!checkRow[row][num] && !checkCol[col][num] && !checkBox[box][num]) {
                board[row][col] = num;
                checkRow[row][num] = true;
                checkCol[col][num] = true;
                checkBox[box][num] = true;

                if (backtrack(row, col + 1))
                    return true;

                board[row][col] = 0;
                checkRow[row][num] = false;
                checkCol[col][num] = false;
                checkBox[box][num] = false;
            }
        }
        return false;
    }

    public static int getBoxIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        board = new int[9][9];
        checkRow = new boolean[9][10];
        checkCol = new boolean[9][10];
        checkBox = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0) {
                    int num = board[i][j];
                    int k = getBoxIndex(i, j);

                    checkRow[i][num] = true;
                    checkCol[j][num] = true;
                    checkBox[k][num] = true;
                }
            }
        }

        backtrack(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                sb.append(board[i][j]).append(" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
