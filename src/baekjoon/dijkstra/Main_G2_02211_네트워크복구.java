package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G2_02211_네트워크복구 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        int[] dist = new int[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Node next : graph.get(cur.num)) {
                if (dist[cur.num] + next.cost < dist[next.num]) {
                    dist[next.num] = dist[cur.num] + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                    parent[next.num] = cur.num;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N - 1).append("\n");
        for (int child = 2; child < N + 1; child++)
            sb.append(child).append(" ").append(parent[child]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
