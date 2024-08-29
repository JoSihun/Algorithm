package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G4_13424_비밀모임 {
    public static int N, M, K;
    public static List<List<Node>> graph;

    public static class Node implements Comparable<Node> {
        public int num, cost;
        
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Node next : graph.get(cur.num)) {
                if (cur.cost + next.cost < dist[next.num]) {
                    dist[next.num] = cur.cost + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < N + 1; i++)
                graph.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, c));
                graph.get(b).add(new Node(a, c));
            }

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] starts = new int[K];
            for (int i = 0; i < K; i++)
                starts[i] = Integer.parseInt(st.nextToken());

            int[][] dists = new int[N + 1][N + 1];
            for (int i = 0; i < K; i++)
                dists[i] = dijkstra(starts[i]);

            int answer = -1;
            int minCost = Integer.MAX_VALUE;
            for (int end = 1; end < N + 1; end++) {
                int cost = 0;
                for (int start = 0; start < K; start++)
                    cost += dists[start][end];

                if (cost < minCost) {
                    minCost = cost;
                    answer = end;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
