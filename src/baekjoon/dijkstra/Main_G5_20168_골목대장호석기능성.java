package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G5_20168_골목대장호석기능성 {
    public static int N, M;
    public static int A, B, C;
    public static List<List<Edge>> graph;

    public static class Edge implements Comparable<Edge> {
        public int num, maxCost, totalCost;

        public Edge(int num, int maxCost) {
            this.num = num;
            this.maxCost = maxCost;
        }

        public Edge(int num, int maxCost, int totalCost) {
            this.num = num;
            this.maxCost = maxCost;
            this.totalCost = totalCost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.maxCost - o.maxCost;
        }
    }

    public static int dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(A, 0, 0));

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.totalCost > C) continue;
            if (cur.num == B) return cur.maxCost;

            for (Edge next : graph.get(cur.num)) {
                int nextMaxCost = Math.max(cur.maxCost, next.maxCost);
                int nextTotalCost = cur.totalCost + next.maxCost;

                if (nextMaxCost < dist[next.num]) {
                    if (nextTotalCost <= C) {
                        dist[next.num] = nextMaxCost;
                        pq.offer(new Edge(next.num, nextMaxCost, nextTotalCost));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, c));
            graph.get(v).add(new Edge(u, c));
        }

        bw.write(dijkstra() + "\n");
        bw.flush();
    }
}
