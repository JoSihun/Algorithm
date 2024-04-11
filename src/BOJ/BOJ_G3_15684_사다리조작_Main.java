package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G3_15684_사다리조작_Main {
    private static int N, M, H;
    private static int answer;
    private static boolean[][] map;

    private static boolean isPossible() {
        for (int col = 1; col < N + 1; col++) {
            int pos = col;
            for (int row = 1; row < H + 1; row++) {
                if (map[row][pos]) pos++;
                else if (map[row][pos - 1]) pos--;
            }
            if (pos != col) return false;
        }
        return true;
    }

    private static void combination(int sr, int cnt, int size) {
        if (answer != Integer.MAX_VALUE) return;

        if (cnt == size) {
            if (isPossible()) answer = size;
            return;
        }

        for (int r = sr; r < H + 1; r++) {
            for (int c = 1; c < N; c++) {
                if (map[r][c]) continue;
                if (map[r][c - 1]) continue;
                if (map[r][c + 1]) continue;

                map[r][c] = true;
                combination(r, cnt + 1, size);
                map[r][c] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        answer = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            combination(1, 0, i);
            if (answer != Integer.MAX_VALUE) break;
        }

        answer = answer != Integer.MAX_VALUE ? answer : -1;
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
