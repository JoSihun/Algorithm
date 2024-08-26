package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_G3_02151_거울설치 {
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static class Node implements Comparable<Node> {
        public int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        int sx = -1, sy = -1, ex = -1, ey = -1;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '#') {
                    if (sx == -1 && sy == -1) {
                        sx = i; sy = j;
                    } else {
                        ex = i; ey = j;
                    }
                }
            }
        }

        int[][][] dist = new int[N][N][4];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int dir = 0; dir < 4; dir++) {
            pq.offer(new Node(sx, sy, dir, 0));
            dist[sx][sy][dir] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.x][cur.y][cur.dir]) continue;

            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == '*') continue;

            if (cur.cost < dist[nx][ny][cur.dir]) {
                dist[nx][ny][cur.dir] = cur.cost;
                pq.offer(new Node(nx, ny, cur.dir, cur.cost));
            }

            if (map[nx][ny] == '!') {
                for (int dir = 0; dir < 4; dir++) {
                    if (dir == cur.dir) continue;
                    if (cur.cost + 1 < dist[nx][ny][dir]) {
                        dist[nx][ny][dir] = cur.cost + 1;
                        pq.offer(new Node(nx, ny, dir, cur.cost + 1));
                    }
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
