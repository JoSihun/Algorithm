package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_01261_알고스팟 {
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
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = line.charAt(j) - '0';
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.cost > dist[node.x][node.y]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (node.cost + map[nx][ny] < dist[nx][ny]) {
                        dist[nx][ny] = node.cost + map[nx][ny];
                        pq.offer(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }

        sb.append(dist[N - 1][M - 1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
