package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G1_01800_인터넷설치 {
    public static int answer;
    public static int N, P, K;
    public static List<List<Edge>> graph;

    public static class Edge implements Comparable<Edge> {
        public int to, cost, used;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public Edge(int to, int cost, int used) {
            this.to = to;
            this.cost = cost;
            this.used = used;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static boolean dijkstra(int budget) {
        int[][] dist = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0, 0));
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.cost > dist[cur.to][cur.used]) continue;

            for (Edge next : graph.get(cur.to)) {
                next.used = next.cost > budget ? cur.used + 1 : cur.used;
                if (next.used <= K && cur.cost + next.cost < dist[next.to][next.used]) {
                    dist[next.to][next.used] = cur.cost + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to][next.used], next.used));
                }
            }
        }

        for (int k = 0; k < K + 1; k++)
            if (dist[N][k] != Integer.MAX_VALUE)
                return true;
        return false;
    }

    public static void binarySearch() {
        int left = 0, right = 1_000_000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dijkstra(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        answer = -1;
        binarySearch();
        bw.write(answer + "\n");
        bw.flush();
    }
}
