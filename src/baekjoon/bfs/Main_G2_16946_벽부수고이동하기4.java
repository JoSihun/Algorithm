package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G2_16946_벽부수고이동하기4 {
    public static int N, M;
    public static int[][] floodFill;
    public static int[][] map, answer;
    public static boolean[][] visited;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static List<Integer> areaSizes = new ArrayList<>();

    public static int bfs(int sx, int sy, int areaIndex) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ sx, sy});
        floodFill[sx][sy] = areaIndex;
        visited[sx][sy] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.poll()[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        count++;
                        visited[nx][ny] = true;
                        floodFill[nx][ny] = areaIndex;
                        queue.offer(new int[]{ nx, ny });
                    }
                }
            }
        }
        return count;
    }

    public static int calculate(int cx, int cy) {
        Set<Integer> set = new HashSet<>();
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
                int areaIndex = floodFill[nx][ny];
                if (!set.contains(areaIndex)) {
                    count += areaSizes.get(areaIndex);
                    set.add(areaIndex);
                }
            }
        }
        return count % 10;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        floodFill = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = line.charAt(j) - '0';
        }

        int areaIndex = 0;
        visited = new boolean[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!visited[x][y] && map[x][y] == 0) {
                    int areaSize = bfs(x, y, areaIndex);
                    areaSizes.add(areaSize);
                    areaIndex++;
                }
            }
        }

        answer = new int[N][M];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    sb.append(calculate(i, j));
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
