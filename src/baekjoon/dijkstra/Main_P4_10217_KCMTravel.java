package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_P4_10217_KCMTravel {
    public static final int INF = Integer.MAX_VALUE / 2;
    public static List<Ticket>[] flights;
    public static int N, M, K;
    public static int[][] dp;

    public static class Ticket {
        public int to, cost, time;

        public Ticket(int to, int cost, int time) {
            this.to = to;
            this.cost = cost;
            this.time = time;
        }
    }

    public static class Airport implements Comparable<Airport> {
        public int num, minTime;

        public Airport(int num, int minTime) {
            this.num = num;
            this.minTime = minTime;
        }

        @Override
        public int compareTo(Airport other) {
            return this.minTime - other.minTime;
        }
    }

    public static void dijkstra() {
        PriorityQueue<Airport> pq = new PriorityQueue<>();
        pq.offer(new Airport(1, 0));
        dp[1][0] = 0;

        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            Airport cur = pq.poll();
            if (cur.num == N) return;
            if (visited[cur.num]) continue;

            visited[cur.num] = true;
            for (Ticket ticket : flights[cur.num]) {
                if (ticket.cost > M) continue;

                int newCost = INF;
                for (int c = 0; c <= M - ticket.cost; c++) {
                    if (dp[cur.num][c] == INF) continue;
                    if (dp[ticket.to][c + ticket.cost] > dp[cur.num][c] + ticket.time) {
                        dp[ticket.to][c + ticket.cost] = dp[cur.num][c] + ticket.time;
                        newCost = Math.min(newCost, dp[cur.num][c] + ticket.time);
                    }
                }
                if (newCost != INF) pq.offer(new Airport(ticket.to, newCost));
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            flights = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++)
                flights[i] = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                flights[u].add(new Ticket(v, c, d));
            }

            dp = new int[N + 1][M + 1];
            for (int i = 2; i <= N; i++)
                Arrays.fill(dp[i], INF);

            dijkstra();
            int result = INF;
            for (int c = 0; c <= M; c++)
                result = Math.min(result, dp[N][c]);
            sb.append(result == INF ? "Poor KCM" : result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
