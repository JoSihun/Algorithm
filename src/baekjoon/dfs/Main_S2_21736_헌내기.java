package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S2_21736_헌내기 {
    private static int N, M, answer;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'P')
            answer++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];;
            int ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (map[nx][ny] != 'X' && !visited[nx][ny]) {
                    dfs(nx, ny);
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
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    sx = i; sy = j;
                }
            }
        }

        visited = new boolean[N][M];
        dfs(sx, sy);

        sb.append(answer == 0 ? "TT" : answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
