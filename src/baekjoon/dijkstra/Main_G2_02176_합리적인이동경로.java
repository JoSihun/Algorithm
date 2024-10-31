package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G2_02176_합리적인이동경로 {
    public static int N, M;
    public static int[] dp, dist;
    public static List<Node>[] graph;

    public static class Node implements Comparable<Node> {
        public int num, cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void dijkstra() {
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(2, 0));
        dist[2] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Node next : graph[cur.num]) {
                if (cur.cost + next.cost < dist[next.num]) {
                    dist[next.num] = cur.cost + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
    }

    public static int countReasonablePath(int num) {
        if (num == 2) return 1;
        if (dp[num] != -1) return dp[num];

        dp[num] = 0;
        for (Node next : graph[num])
            if (dist[next.num] < dist[num])
                dp[num] += countReasonablePath(next.num);

        return dp[num];
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
            int A  = Integer.parseInt(st.nextToken());
            int B  = Integer.parseInt(st.nextToken());
            int C  = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        dijkstra();
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        System.out.println(countReasonablePath(1));
    }
}
