package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_20046_RoadReconstruction {
    public static int N, M;
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

    public static int[][] dijkstra() {
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.x][cur.y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != -1) {
                    if (cur.cost + map[nx][ny] < dist[nx][ny]) {
                        dist[nx][ny] = cur.cost + map[nx][ny];
                        pq.offer(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        if (map[0][0] == -1 || map[N - 1][M - 1] == -1) {
            bw.write("-1\n");
            bw.flush();
            return;
        }

        int[][] dist = dijkstra();
        int answer = dist[N - 1][M - 1] == Integer.MAX_VALUE ? -1 : dist[N - 1][M - 1];
        bw.write(answer + "\n");
        bw.flush();
    }
}
