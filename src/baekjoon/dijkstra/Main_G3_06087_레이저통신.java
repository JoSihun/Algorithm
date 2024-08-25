package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G3_06087_레이저통신 {
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static class Point implements Comparable<Point> {
        int x, y, dir, cost;

        public Point(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
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
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] map = new char[H][W];
        int sx = -1, sy = -1, ex = -1, ey = -1;
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'C') {
                    if (sx == -1 && sy == -1) {
                        sx = i; sy = j;
                    } else {
                        ex = i; ey = j;
                    }
                }
            }
        }

        int[][][] dist = new int[H][W][4];
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int dir = 0; dir < 4; dir++) {
            pq.offer(new Point(sx, sy, dir, 0));
            dist[sx][sy][dir] = 0;
        }

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.cost > dist[cur.x][cur.y][cur.dir]) continue;

            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];
            if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '*') continue;

            // 원래 진행방향대로 진행하는 경우
            if (cur.cost < dist[nx][ny][cur.dir]) {
                dist[nx][ny][cur.dir] = cur.cost;
                pq.offer(new Point(nx, ny, cur.dir, cur.cost));
            }

            // 거울을 사용해 진행방향이 바뀌는 경우
            for (int dir = 0; dir < 4; dir++) {
                if (dir == cur.dir) continue;
                if (cur.cost + 1 < dist[nx][ny][dir]) {
                    dist[nx][ny][dir] = cur.cost + 1;
                    pq.offer(new Point(nx, ny, dir, cur.cost + 1));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int dir = 0; dir < 4; dir++)
            answer = Math.min(answer, dist[ex][ey][dir]);

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
