package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G3_17779_게리맨더링2_Main {
    static int N, answer;
    static int[][] map, area;

    private static void drawLine(int x, int y, int d1, int d2) {
        area = new int[N + 1][N + 1];
        for (int i = 0; i <= d1; i++) {
            area[x + i][y - i] = 5;
            area[x + d2 + i][y + d2 - i] = 5;
        }
        for (int i = 0; i <= d2; i++) {
            area[x + i][y + i] = 5;
            area[x + d1 + i][y - d1 + i] = 5;
        }
    }

    private static void fillArea(int x, int y, int d1, int d2) {
        for (int r = 1; r < x + d1 ; r++) {
            for (int c = 1; c <= y ; c++) {
                if (area[r][c] == 5) break;
                area[r][c] = 1;
            }
        }

        for (int r = 1; r <= x + d2 ; r++) {
            for (int c = N; c > y ; c--) {
                if (area[r][c] == 5) break;
                area[r][c] = 2;
            }
        }

        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (area[r][c] == 5) break;
                area[r][c] = 3;
            }
        }

        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = N; c >= y - d1 + d2; c--) {
                if (area[r][c] == 5) break;
                area[r][c] = 4;
            }
        }
    }

    private static void calculateDifference() {
        int[] population = new int[6];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                population[area[i][j]] += map[i][j];
        population[5] += population[0];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 5; i++) {
            max = Math.max(max, population[i]);
            min = Math.min(min, population[i]);
        }
        answer = Math.min(answer, max - min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {
                            drawLine(x, y, d1, d2);
                            fillArea(x, y, d1, d2);
                            calculateDifference();
                        }
                    }
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
