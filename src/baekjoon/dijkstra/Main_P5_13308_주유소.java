package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_P5_13308_주유소 {
    public static class Edge implements Comparable<Edge> {
        public int to, price;
        public long cost;

        public Edge(int to, long cost, int price) {
            this.to = to;
            this.cost = cost;
            this.price = price;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prices = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            prices[i] = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, w, prices[b]));
            graph.get(b).add(new Edge(a, w, prices[a]));
        }

        long[][] dist = new long[N + 1][2501];
        for (int i = 0; i < N + 1; i++)
            Arrays.fill(dist[i], Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0, prices[1]));
        dist[1][prices[1]] = 0;

        long answer = Long.MAX_VALUE;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.to == N) { answer = cur.cost; break; }
            if (cur.cost > dist[cur.to][cur.price]) continue;

            for (Edge next : graph.get(cur.to)) {                       // 현재 주유소와 연결된 다음 주유소
                int nextPrice = Math.min(cur.price, next.price);        // 현재 주유소의 단가와 다음 주유소의 단가 비교
                long nextCost = cur.cost + next.cost * cur.price;       // 다음 주요소에 도착할 때까지 드는 누적 비용

                if (nextCost < dist[next.to][nextPrice]) {
                    dist[next.to][nextPrice] = nextCost;
                    pq.offer(new Edge(next.to, nextCost, nextPrice));
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
