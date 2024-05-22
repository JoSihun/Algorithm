package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_G3_17142_연구소3_Main {
    static int N, M;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static List<Virus> viruses;
    static int answer = Integer.MAX_VALUE;;

    static class Virus {
        int x, y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void combination(int start, int depth, int[] candidates) {
        if (depth == M) {
            bfs(candidates);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            candidates[depth] = i;
            combination(i + 1, depth + 1, candidates);
        }
    }

    private static void bfs(int[] candidates) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        for (int index : candidates) {
            Virus virus = viruses.get(index);
            visited[virus.x][virus.y] = true;
            queue.offer(new int[] { virus.x, virus.y, 0 });
        }

        int endTime = 0;
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int z = queue.poll()[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (map[nx][ny] != 1 && !visited[nx][ny]) {
                        if (map[nx][ny] == 0)
                            endTime = Math.max(endTime, z + 1);
                        visited[nx][ny] = true;
                        queue.offer(new int[] { nx, ny, z + 1 });
                    }
                }
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (map[i][j] == 0 && !visited[i][j])
                    return;

        answer = Math.min(answer, endTime);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) viruses.add(new Virus(i, j));
            }
        }

        combination(0, 0, new int[M]);
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
