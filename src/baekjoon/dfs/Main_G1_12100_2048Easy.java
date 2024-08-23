package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G1_12100_2048Easy {
    public static int N, answer;
    public static int[][] board;

    public static void dfs(int depth, int[][] map) {
        if (depth == 5) {
            answer = Math.max(answer, findMax(map));
            return;
        }

        for (int dir = 0; dir < 4; dir++)
            dfs(depth + 1, move(dir, map));
    }

    public static int[][] move(int dir, int[][] map) {
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] newLine = new int[N];
            int idx = (dir == 0 || dir == 3) ? 0 : N - 1;

            for (int j = 0; j < N; j++) {
                // 0 : 왼쪽, 1 : 오른쪽, 2 : 위쪽, 3 : 아래쪽
                int value = (dir == 0) ? map[i][j] :
                            (dir == 1) ? map[i][N - j - 1] :
                            (dir == 2) ? map[j][i] : map[N - j - 1][i];
                if (value == 0) continue;

                if (newLine[idx] == 0) {
                    newLine[idx] = value;
                } else if (newLine[idx] == value) {
                    newLine[idx] += value;
                    idx = (dir == 0 || dir == 3) ? idx + 1 : idx - 1;
                } else {
                    idx = (dir == 0 || dir == 3) ? idx + 1 : idx - 1;
                    newLine[idx] = value;
                }
            }

            for (int j = 0; j < N; j++) {
                if (dir == 0) newMap[i][j] = newLine[j];
                else if (dir == 1) newMap[i][N - j - 1] = newLine[j];
                else if (dir == 2) newMap[j][i] = newLine[j];
                else if (dir == 3) newMap[N - j - 1][i] = newLine[j];
            }
        }
        return newMap;
    }

    public static int findMax(int[][] map) {
        int max = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                max = Math.max(max, map[i][j]);
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, board);
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
