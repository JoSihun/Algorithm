package BOJ.silver;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_14940_쉬운최단거리_Main {
    private static int N, M;
    private static int[][] map, answer;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    public static void bfs(int sx, int sy, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{ sx, sy });
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.poll()[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        answer[nx][ny] = answer[x][y] + 1;
                        queue.offer(new int[]{ nx, ny });
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sx = 0, sy = 0;
        map = new int[N][M];
        answer = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) { sx = i; sy = j;}
                else if (map[i][j] == 1) answer[i][j] = -1;
            }
        }

        bfs(sx, sy, new boolean[N][M]);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(answer[i][j]).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
