package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G2_01445_일요일아침의데이트 {
    public static int N, M;
    public static int sx, sy, ex, ey;
    public static int[] cost1;
    public static int[] cost2;

    public static char[][] map;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static class Node implements Comparable<Node> {
        public int x, y, garbage, nearGarbage;

        public Node(int x, int y, int garbage, int nearGarbage) {
            this.x = x;
            this.y = y;
            this.garbage = garbage;
            this.nearGarbage = nearGarbage;
        }

        @Override
        public int compareTo(Node o) {
            if (this.garbage == o.garbage)
                return Integer.compare(this.nearGarbage, o.nearGarbage);
            return Integer.compare(this.garbage, o.garbage);
        }
    }

    public static void preprocessNearGarbage() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] != 'g') continue;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                        if (map[nx][ny] == '.')
                            map[nx][ny] = 'n';
                    }
                }
            }
        }
    }

    public static void dijkstra() {
        cost1 = new int[N * M]; cost2 = new int[N * M];
        Arrays.fill(cost1, Integer.MAX_VALUE);
        Arrays.fill(cost2, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(sx, sy, 0, 0));
        cost1[sx * M + sy] = 0;
        cost2[sx * M + sy] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.garbage > cost1[cur.x * M + cur.y]) continue;
            if (cur.garbage == cost1[cur.x * M + cur.y] && cur.nearGarbage > cost2[cur.x * M + cur.y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    int newCntGarbage = cur.garbage + (map[nx][ny] == 'g' ? 1 : 0);
                    int newCntNearGarbage = cur.nearGarbage + (map[nx][ny] == 'n' ? 1 : 0);

                    boolean condition1 = newCntGarbage < cost1[nx * M + ny];
                    boolean condition2 = newCntGarbage == cost1[nx * M + ny] && newCntNearGarbage < cost2[nx * M + ny];
                    if (condition1 || condition2) {
                        cost1[nx * M + ny] = newCntGarbage;
                        cost2[nx * M + ny] = newCntNearGarbage;
                        pq.offer(new Node(nx, ny, newCntGarbage, newCntNearGarbage));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    sx = i; sy = j;
                } else if (map[i][j] == 'F') {
                    ex = i; ey = j;
                }
            }
        }

        preprocessNearGarbage();
        dijkstra();

        bw.write(cost1[ex * M + ey] + " " + cost2[ex * M + ey]);
        bw.flush();
    }
}
