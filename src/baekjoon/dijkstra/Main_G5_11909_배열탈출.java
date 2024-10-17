package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_11909_배열탈출 {
    public static int N;
    public static int answer;
    public static int[][] map;
    public static int[] dx = { 1, 0 };
    public static int[] dy = { 0, 1 };

    public static class Node implements Comparable<Node> {
        public int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void dijkstra() {
        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(cost[i], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(0, 0, 0));
        cost[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > cost[cur.x][cur.y]) continue;
            if (cur.x == N - 1 && cur.y == N - 1) {
                answer = cur.cost;
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < N && ny < N) {
                    int nextCost = cur.cost + Math.max(0, map[nx][ny] - map[cur.x][cur.y] + 1);
                    if (nextCost < cost[nx][ny]) {
                        cost[nx][ny] = nextCost;
                        pq.offer(new Node(nx, ny, nextCost));
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

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dijkstra();
        bw.write(answer + "\n");
        bw.flush();
    }
}
