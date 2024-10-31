package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G1_24042_횡단보도 {
    public static int N, M;
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

    public static long dijkstra() {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;
            if (cur.num == N) return cur.cost;

            for (Node next : graph[cur.num]) {
                long newCost = getNextAvailableTime(cur.cost, next.cost) + 1;
                if (newCost < dist[next.num]) {
                    dist[next.num] = newCost;
                    pq.offer(new Node(next.num, newCost));
                }
            }
        }
        return -1;
    }

    public static long getNextAvailableTime(long currentTime, long interval) {
        if (currentTime % M <= interval)
            return currentTime / M * M + interval;
        return (currentTime / M + 1) * M + interval;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, i));
            graph[B].add(new Node(A, i));
        }
        System.out.println(dijkstra());
    }
}
