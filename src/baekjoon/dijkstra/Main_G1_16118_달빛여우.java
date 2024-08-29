package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G1_16118_달빛여우 {
    public static int N, M;
    public static int[] dist4Fox;
    public static int[][] dist4Wolf;
    public static List<List<Node>> graph;

    public static class Node implements Comparable<Node> {
        public int num, cost;
        public boolean isFast;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        public Node(int num, int cost, boolean isFast) {
            this.num = num;
            this.cost = cost;
            this.isFast = isFast;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void dijkstra4Fox() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;

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
        dist4Fox = dist;
    }

    public static void dijkstra4Wolf() {
        int[][] dist = new int[2][N + 1];
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        Arrays.fill(dist[1], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, true));
        dist[1][1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curState = cur.isFast ? 1 : 0;
            if (cur.cost > dist[curState][cur.num]) continue;

            for (Node next : graph.get(cur.num)) {
                int nextCost = cur.isFast ? next.cost / 2: next.cost * 2;
                int nextState = cur.isFast ? 0 : 1;
                if (cur.cost + nextCost < dist[nextState][next.num]) {
                    dist[nextState][next.num] = cur.cost + nextCost;
                    pq.offer(new Node(next.num, cur.cost + nextCost, !cur.isFast));
                }
            }
        }
        dist4Wolf = dist;
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
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c * 2));
            graph.get(b).add(new Node(a, c * 2));
        }
        dijkstra4Fox();
        dijkstra4Wolf();

        int answer = 0;
        for (int num = 1; num < N + 1; num++)
            if (dist4Fox[num] < Math.min(dist4Wolf[0][num], dist4Wolf[1][num]))
                answer++;
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
