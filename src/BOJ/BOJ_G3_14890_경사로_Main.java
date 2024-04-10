package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_G3_14890_경사로_Main {
    private static int N, L;
    private static int answer;
    private static int[][] map;

    private static boolean checkRow(int row) {
        boolean[] slope = new boolean[N];
        for (int col = 0; col < N - 1; col++) {
            if (map[row][col] == map[row][col + 1]) continue;
            if (Math.abs(map[row][col] - map[row][col + 1]) > 1) return false;

            // 올라가는 경사로
            if (map[row][col] - map[row][col + 1] == -1) {
                for (int l = col; l > col - L ; l--) {
                    if (l < 0 || map[row][l] != map[row][col] || slope[l]) return false;
                    slope[l] = true;
                }
            // 내려가는 경사로
            } else {
                for (int l = col + 1; l <= col + L ; l++) {
                    if (l >= N || map[row][l] != map[row][col + 1] || slope[l]) return false;
                    slope[l] = true;
                }
            }
        }
        return true;
    }

    private static boolean checkCol(int col) {
        boolean[] slope = new boolean[N];
        for (int row = 0; row < N - 1; row++) {
            if (map[row][col] == map[row + 1][col]) continue;
            if (Math.abs(map[row][col] - map[row + 1][col]) > 1) return false;

            // 올라가는 경사로
            if (map[row][col] - map[row + 1][col] == -1) {
                for (int l = row; l > row - L ; l--) {
                    if (l < 0 || map[l][col] != map[row][col] || slope[l]) return false;
                    slope[l] = true;
                }
                // 내려가는 경사로
            } else {
                for (int l = row + 1; l <= row + L ; l++) {
                    if (l >= N || map[l][col] != map[row + 1][col] || slope[l]) return false;
                    slope[l] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // L개의 연속된 같은 높이의 낮은 칸
        // 연속된 칸 직전 혹은 직후 칸과의 차이가 1
        answer = 0;
        for (int i = 0; i < N; i++) {
            if (checkRow(i)) answer++;
            if (checkCol(i)) answer++;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
