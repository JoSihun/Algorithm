package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G2_16681_등산 {
    public static int N, M, D, E;
    public static int[] heights;
    public static List<Node>[] graph;

    public static class Node implements Comparable<Node> {
        public int num;
        public long cost;

        public Node(int num, long cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static long[] dijkstra(int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Node next : graph[cur.num]) {
                if (heights[cur.num] < heights[next.num]) {
                    if (cur.cost + next.cost < dist[next.num]) {
                        dist[next.num] = cur.cost + next.cost;
                        pq.offer(new Node(next.num, dist[next.num]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        heights = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, n));
            graph[b].add(new Node(a, n));
        }

        long[] distFromHome = dijkstra(1);
        long[] distFromSchool = dijkstra(N);

        long answer = Long.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            if (distFromHome[i] != Long.MAX_VALUE && distFromSchool[i] != Long.MAX_VALUE) {
                long value = heights[i] * (long) E - (distFromHome[i] + distFromSchool[i]) * D;
                answer = Math.max(answer, value);
            }
        }
        System.out.println(answer == Long.MIN_VALUE ? "Impossible" : answer);
    }
}
