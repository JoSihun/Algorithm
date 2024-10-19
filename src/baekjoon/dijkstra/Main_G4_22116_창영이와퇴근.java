package baekjoon.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_22116_창영이와퇴근 {
    public static int N;
    public static int answer;

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

    public static void dijkstra() {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.x][cur.y]) continue;
            if (cur.x == N - 1 && cur.y == N - 1) {
                answer = cur.cost;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    int slope = Math.abs(map[nx][ny] - map[cur.x][cur.y]);
                    int newCost = Math.max(cur.cost, slope);

                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
        answer = dist[N - 1][N - 1];
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
