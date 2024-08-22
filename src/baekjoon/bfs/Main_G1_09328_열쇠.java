package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Main_G1_09328_열쇠 {
    public static int H, W;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static boolean[] hasKey;
    public static List<int[]>[] laterVisit;

    public static int bfs() {
        visited = new boolean[H + 2][W + 2];
        visited[0][0] = true;

        laterVisit = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            laterVisit[i] = new ArrayList<>();

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        int answer = 0;

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.poll()[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= H + 2 || ny >= W + 2)
                    continue;
                if (visited[nx][ny] || map[nx][ny] == '*')
                    continue;

                visited[nx][ny] = true;

                if (map[nx][ny] == '.') {
                    queue.offer(new int[] {nx, ny});
                } else if (map[nx][ny] == '$') {
                    answer++;
                    queue.offer(new int[] {nx, ny});
                } else if ('A' <= map[nx][ny] && map[nx][ny] <= 'Z') {
                    if (hasKey[map[nx][ny] - 'A']) {
                        queue.offer(new int[] {nx, ny});
                        continue;
                    }
                    laterVisit[map[nx][ny] - 'A'].add(new int[] {nx, ny});
                } else if ('a' <= map[nx][ny] && map[nx][ny] <= 'z') {
                    hasKey[map[nx][ny] - 'a'] = true;
                    queue.offer(new int[] {nx, ny});
                    for (int[] pos : laterVisit[map[nx][ny] - 'a'])
                        queue.offer(pos);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H + 2][W + 2];
            Arrays.fill(map[0], '.');
            Arrays.fill(map[H + 1], '.');

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                map[i + 1][0] = map[i + 1][W + 1] = '.';
                for (int j = 0; j < W; j++)
                    map[i + 1][j + 1] = line.charAt(j);
            }

            hasKey = new boolean[26];
            String keys = br.readLine();
            if (!keys.equals("0"))
                for (char key : keys.toCharArray())
                    hasKey[key - 'a'] = true;

            sb.append(bfs()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
