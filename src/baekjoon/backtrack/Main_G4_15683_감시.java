package baekjoon.backtrack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G4_15683_감시 {
    private static int N, M;
    private static int answer;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    private static int[] dy = {1, 0, -1, 0}; // 우, 하, 좌, 상
    private static List<int[]> cctv;

    public static void backtrack(int cnt) {
        if (cnt == cctv.size()) {
            int[][] copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }
            simulate(copyMap);
            return;
        }

        cctv.get(cnt)[2] = 0;
        backtrack(cnt + 1);
        cctv.get(cnt)[2] = 1;
        backtrack(cnt + 1);
        cctv.get(cnt)[2] = 2;
        backtrack(cnt + 1);
        cctv.get(cnt)[2] = 3;
        backtrack(cnt + 1);
    }

    public static void simulate(int[][] copyMap) {
        for (int i = 0; i < cctv.size(); i++) {
            int[] curCctv = cctv.get(i);
            int x = curCctv[0];
            int y = curCctv[1];
            int dir = curCctv[2];
            int type = curCctv[3];

            if (type == 1) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                    if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;

                    nx += dx[dir];
                    ny += dy[dir];
                }
            } else if (type == 2) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                    if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
                nx = x + dx[(dir + 2) % 4];
                ny = y + dy[(dir + 2) % 4];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                    if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;
                    nx += dx[(dir + 2) % 4];
                    ny += dy[(dir + 2) % 4];
                }
            } else if (type == 3) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                    if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
                nx = x + dx[(dir + 3) % 4];
                ny = y + dy[(dir + 3) % 4];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                    if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;
                    nx += dx[(dir + 3) % 4];
                    ny += dy[(dir + 3) % 4];
                }
            } else if (type == 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                    if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
                nx = x + dx[(dir + 2) % 4];
                ny = y + dy[(dir + 2) % 4];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                    if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;
                    nx += dx[(dir + 2) % 4];
                    ny += dy[(dir + 2) % 4];
                }
                nx = x + dx[(dir + 3) % 4];
                ny = y + dy[(dir + 3) % 4];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                    if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;
                    nx += dx[(dir + 3) % 4];
                    ny += dy[(dir + 3) % 4];
                }
            } else if (type == 5) {
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    while (0 <= nx && nx < N && 0 <= ny && ny < M && copyMap[nx][ny] != 6) {
                        if (copyMap[nx][ny] == 0) copyMap[nx][ny] = -1;
                        nx += dx[d];
                        ny += dy[d];
                    }
                }
            }
        }
        count(copyMap);
    }

    public static void count(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }
        answer = Math.min(answer, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctv = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new int[] {i, j, 0, map[i][j]});
                }
            }
        }

        answer = Integer.MAX_VALUE;
        backtrack(0);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
