package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_P5_05719_거의최단경로 {
    public static int N, M;
    public static int[] dist;
    public static List<List<Node>> graph;
    public static List<List<Integer>> prev;

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

    public static void dijkstra(int start) {
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Node next : graph.get(cur.num)) {
                if (dist[cur.num] + next.cost < dist[next.num]) {
                    dist[next.num] = dist[cur.num] + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                    prev.get(next.num).clear();
                    prev.get(next.num).add(cur.num);
                } else if (dist[cur.num] + next.cost == dist[next.num]) {
                    prev.get(next.num).add(cur.num);
                }
            }
        }
    }

    public static void removeShortestPath(int dst) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        visited[dst] = true;
        queue.offer(dst);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : prev.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }

                graph.get(next).removeIf(node -> node.num == cur);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            prev = new ArrayList<>();
            for (int i = 0; i < N; i++)
                prev.add(new ArrayList<>());

            graph = new ArrayList<>();
            for (int i = 0; i < N; i++)
                graph.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                graph.get(U).add(new Node(V, P));
            }

            dijkstra(S);
            removeShortestPath(D);
            dijkstra(S);

            sb.append(dist[D] == Integer.MAX_VALUE ? -1 : dist[D]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
