package baekjoon.implementation;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_20058_마법사상어와파이어스톰 {
    private static int N, Q;
    private static int[][] map;
    private static int answer1, answer2;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    private static void fireStorm(int L) {
        int size = (int) Math.pow(2, L);
        for (int i = 0; i < N; i += size)
            for (int j = 0; j < N; j += size)
                rotate(i, j, size);
        meltingIce();
    }

    private static void rotate(int x, int y, int size) {
        int[][] temp = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                temp[j][size - i - 1] = map[x + i][y + j];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                map[x + i][y + j] = temp[i][j];
    }

    private static void meltingIce() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] <= 0) continue;
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] > 0)
                        count++;
                }

                if (count < 3) queue.offer(new int[] { x, y });
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.poll()[1];
            map[x][y]--;
        }
    }

    private static void countAnswer1() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                answer1 += map[i][j];
    }

    private static void countAnswer2() {
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || visited[i][j]) continue;
                answer2 = Math.max(answer2, bfs(i, j, visited));
            }
        }
    }

    private static int bfs(int sx, int sy, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { sx, sy });
        visited[sx][sy] = true;

        int size = 0;
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.poll()[1];
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (map[nx][ny] > 0 && !visited[nx][ny]) {
                        queue.offer(new int[] { nx, ny });
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++)
            fireStorm(Integer.parseInt(st.nextToken()));

        countAnswer1();
        countAnswer2();

        sb.append(answer1).append("\n").append(answer2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
