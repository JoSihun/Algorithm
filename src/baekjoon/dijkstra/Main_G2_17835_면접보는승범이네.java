package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G2_17835_면접보는승범이네 {
    public static int N, M, K;
    public static long[] dist;
    public static int[] interviewCity;
    public static List<List<Edge>> graph;

    public static class Edge implements Comparable<Edge> {
        public int to;
        public long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void dijkstra() {
        dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int num : interviewCity) {
            pq.offer(new Edge(num, 0));
            dist[num] = 0;
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;

            for (Edge next : graph.get(cur.to)) {
                if (cur.cost + next.cost < dist[next.to]) {
                    dist[next.to] = cur.cost + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
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
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(V).add(new Edge(U, C));
        }

        st = new StringTokenizer(br.readLine());

        interviewCity = new int[K];
        for (int i = 0; i < K; i++)
            interviewCity[i] = Integer.parseInt(st.nextToken());

        dijkstra();
        int answer1 = Integer.MIN_VALUE;
        long answer2 = Integer.MIN_VALUE;
        for (int num = 1; num <= N; num++) {
            if (dist[num] > answer2) {
                answer2 = dist[num];
                answer1 = num;
            }
        }

        bw.write(answer1 + "\n" + answer2 + "\n");
        bw.flush();
    }
}
