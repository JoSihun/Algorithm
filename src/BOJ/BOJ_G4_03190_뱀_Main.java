package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_G4_03190_뱀_Main {
    private static int answer;
    private static int N, K, L;

    private static int[][] map;
    private static int[] dr = {0, 1, 0, -1};    // 우 하 좌 상
    private static int[] dc = {1, 0, -1, 0};    // 우 하 좌 상

    private static List<Snake> snake;
    private static Map<Integer, String> command;

    public static class Snake {
        int r, c, d;

        public Snake(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void simulate() {
        answer++;
        Snake head = snake.get(snake.size() - 1);
        int nr = head.r + dr[head.d];
        int nc = head.c + dc[head.d];
        int nd = head.d;

        if (command.containsKey(answer)) {
            String c = command.get(answer);
            if (c.equals("L")) {
                nd = (nd + 3) % 4;
            } else {
                nd = (nd + 1) % 4;
            }
        }

        if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1)
            return;

        if (map[nr][nc] == 2) {
            map[nr][nc] = 1;
            snake.add(new Snake(nr, nc, nd));
        } else {
            map[nr][nc] = 1;
            snake.add(new Snake(nr, nc, nd));
            Snake tail = snake.remove(0);
            map[tail.r][tail.c] = 0;
        }

        simulate();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 2;
        }

        command = new HashMap<>();
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            command.put(X, C);
        }

        snake = new ArrayList<>();
        snake.add(new Snake(0, 0, 0));
        simulate();

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
