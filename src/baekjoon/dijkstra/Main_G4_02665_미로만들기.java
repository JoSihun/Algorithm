package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_G4_02665_미로만들기 {
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
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] room = new int[N][N];
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = line.charAt(j) - '0';
                room[i][j] = room[i][j] == 1 ? 0 : 1;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.x][cur.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (cur.cost + room[nx][ny] < dist[nx][ny]) {
                        dist[nx][ny] = cur.cost + room[nx][ny];
                        pq.offer(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }

        sb.append(dist[N - 1][N - 1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
