package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G1_02307_도로검문 {
    public static int N, M;
    public static int[] parent;
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

    public static int[] dijkstra(int blockFrom, int blockTo) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Node next : graph.get(cur.num)) {
                if (cur.num == blockFrom && next.num == blockTo) continue;
                if (cur.num == blockTo && next.num == blockFrom) continue;
                if (cur.cost + next.cost < dist[next.num]) {
                    if (blockFrom == -1 && blockTo == -1)
                        parent[next.num] = cur.num;
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, t));
            graph.get(b).add(new Node(a, t));
        }

        parent = new int[N + 1];
        int[] minPath = dijkstra(-1, -1);
        if (minPath[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int answer = 0, child = N;
        while (parent[child] != 0) {
            int from = parent[child];
            int to = child;

            int[] path = dijkstra(from, to);
            answer = path[N] == Integer.MAX_VALUE ? Integer.MAX_VALUE :
                    Math.max(answer, path[N] - minPath[N]);

            if (answer == Integer.MAX_VALUE) break;
            child = parent[child];
        }

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));
        bw.flush();
    }
}
