package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G2_01486_등산 {
    public static int N, M, T, D;
    public static int[] cost1, cost2;

    public static int[][] map;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static class Node implements Comparable<Node> {
        public int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int[] dijkstra(boolean reverse) {
        int[] cost = new int[N * M];
        Arrays.fill(cost, D + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        cost[0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > cost[cur.x * M + cur.y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    int diff = reverse ? map[cur.x][cur.y] - map[nx][ny] : map[nx][ny] - map[cur.x][cur.y];
                    if (Math.abs(diff) <= T) {
                        int newCost = cur.cost + (diff <= 0 ? 1 : diff * diff);
                        if (newCost < cost[nx * M + ny]) {
                            cost[nx * M + ny] = newCost;
                            pq.offer(new Node(nx, ny, newCost));
                        }
                    }
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if ('A' <= c && c <= 'Z')
                    map[i][j] = c - 'A';
                else if ('a' <= c && c <= 'z')
                    map[i][j] = c - 'a' + 26;
            }
        }

        cost1 = dijkstra(true);
        cost2 = dijkstra(false);

        int answer = map[0][0];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < M; y++)
                if (cost1[x * M + y] + cost2[x * M + y] <= D)
                    answer = Math.max(answer, map[x][y]);
        bw.write(answer + "\n");
        bw.flush();
    }
}
