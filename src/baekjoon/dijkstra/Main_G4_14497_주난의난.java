package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G4_14497_주난의난 {
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static class Point implements Comparable<Point> {
        int x, y, cost;

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = line.charAt(j) - '0';
        }
        map[x1][y1] = 0; map[x2][y2] = 1;

        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(x1, y1, 0));
        dist[x1][y1] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.x == x2 && cur.y == y2) break;
            if (cur.cost > dist[cur.x][cur.y]) continue;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (cur.cost + map[nx][ny] < dist[nx][ny]) {
                    dist[nx][ny] = cur.cost + map[nx][ny];
                    pq.offer(new Point(nx, ny, dist[nx][ny]));
                }
            }
        }

        bw.write(String.valueOf(dist[x2][y2]));
        bw.flush();
    }
}
