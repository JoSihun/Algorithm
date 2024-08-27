package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_P4_09376_탈옥 {
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.cost = 0;
        }

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H + 2][W + 2];
            for (int h = 1; h < H + 1; h++)
                Arrays.fill(map[h], '.');

            for (int h = 1; h < H + 1; h++) {
                String line = br.readLine();
                for (int w = 1; w < W + 1; w++)
                    map[h][w] = line.charAt(w - 1);
            }

            int idx = 0;
            Point[] points = new Point[3];
            points[idx++] = new Point(0, 0);

            for (int h = 1; h < H + 1; h++)
                for (int w = 1; w < W + 1; w++)
                    if (map[h][w] == '$') points[idx++] = new Point(h, w);

            int[][][] dist = new int[H + 2][W + 2][3];
            for (int h = 0; h < H + 2; h++)
                for (int w = 0; w < W + 2; w++)
                    Arrays.fill(dist[h][w], Integer.MAX_VALUE);

            for (int index = 0; index < 3; index++) {
                int sx = points[index].x;
                int sy = points[index].y;

                PriorityQueue<Point> pq = new PriorityQueue<>();
                pq.offer(new Point(sx, sy, 0));
                dist[sx][sy][index] = 0;

                while (!pq.isEmpty()) {
                    Point cur = pq.poll();
                    if (cur.cost > dist[cur.x][cur.y][index]) continue;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= H + 2 || ny >= W + 2) continue;
                        if (map[nx][ny] == '*') continue;

                        int nextCost = map[nx][ny] == '#' ? cur.cost + 1 : cur.cost;
                        if (nextCost < dist[nx][ny][index]) {
                            dist[nx][ny][index] = nextCost;
                            pq.offer(new Point(nx, ny, nextCost));
                        }
                    }
                }
            }

            int answer = Integer.MAX_VALUE;
            for (int h = 0; h < H + 2; h++) {
                for (int w = 0; w < W + 2; w++) {
                    if (map[h][w] == '*') continue;
                    int cost = dist[h][w][0] + dist[h][w][1] + dist[h][w][2];
                    cost = map[h][w] == '#' ? cost - 2 : cost;
                    answer = Math.min(answer, cost);
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
