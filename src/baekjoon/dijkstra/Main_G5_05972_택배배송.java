package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G5_05972_택배배송 {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

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
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (dist[node.num] < node.cost) continue;

            for (Node next : graph.get(node.num)) {
                if (node.cost + next.cost < dist[next.num]) {
                    dist[next.num] = node.cost + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

        sb.append(dist[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
