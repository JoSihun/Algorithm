package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G2_13911_집구하기 {
    public static int V, E;
    public static List<Edge>[] graph;

    public static class Edge implements Comparable<Edge> {
        public int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static int[] dijkstra(int[] stores) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int store : stores) {
            pq.offer(new Edge(store, 0));
            dist[store] = 0;
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.dist > dist[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                if (cur.dist + next.dist < dist[next.to]) {
                    dist[next.to] = cur.dist + next.dist;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
        
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] mcdonalds = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) mcdonalds[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] starbucks = new int[S];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) starbucks[i] = Integer.parseInt(st.nextToken());

        int[] distMcDonalds = dijkstra(mcdonalds);
        int[] distStarBucks = dijkstra(starbucks);

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < V + 1; i++)
            if (0 < distMcDonalds[i] && distMcDonalds[i] <= x)
                if (0 < distStarBucks[i] && distStarBucks[i] <= y)
                    answer = Math.min(answer, distMcDonalds[i] + distStarBucks[i]);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
