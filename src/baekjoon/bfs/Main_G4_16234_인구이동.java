package baekjoon.bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_16234_인구이동 {
    private static int N, L, R;
    private static int answer;

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static boolean bfs(int sr, int sc) {
        Queue<int[]> queue1 = new ArrayDeque<>();
        Queue<int[]> queue2 = new ArrayDeque<>();
        queue1.offer(new int[] {sr, sc});
        queue2.offer(new int[] {sr, sc});
        visited[sr][sc] = true;

        int cnt = 0;
        int sum = 0;
        while (!queue1.isEmpty()) {
            int r = queue1.peek()[0];
            int c = queue1.poll()[1];

            cnt++;
            sum += map[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                int diff = Math.abs(map[r][c] - map[nr][nc]);

                if (L <= diff && diff <= R) {
                    queue1.offer(new int[] {nr, nc});
                    queue2.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        if (cnt > 1) {
            int avg = sum / cnt;
            while (!queue2.isEmpty()) {
                int r = queue2.peek()[0];
                int c = queue2.poll()[1];
                map[r][c] = avg;
            }
        }

        return cnt > 1 ? true : false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (!visited[i][j])
                        if (bfs(i, j)) flag = true;
            if (!flag) break;
            answer++;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
