package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_01584_게임 {
    private static int[][] map = new int[501][501];
    private static int[][] dist = new int[501][501];
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    public static class Node implements Comparable<Node> {
        public int x, y, cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void dijkstra() {
        for (int i = 0; i < 501; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.cost > dist[node.x][node.y]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (0 <= nx && nx < 501 && 0 <= ny && ny < 501) {
                    int newCost = node.cost;
                    if (map[nx][ny] == 1) newCost += 1;
                    else if (map[nx][ny] == 2) newCost = Integer.MAX_VALUE;
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++)
                for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++)
                    map[x][y] = 1;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++)
                for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++)
                    map[x][y] = 2;
        }

        dijkstra();
        sb.append(dist[500][500] == Integer.MAX_VALUE ? -1 : dist[500][500]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
