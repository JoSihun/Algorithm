package BOJ.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ_S1_01446_지름길_Main {

    public static class Node implements Comparable<Node> {
        int num, cost;
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
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < D + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < D; i++) {
            graph.get(i).add(new Node(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (e < D + 1)
                graph.get(s).add(new Node(e, d));
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (dist[node.num] < node.cost) continue;
            for (Node next : graph.get(node.num)) {
                if (node.cost + next.cost < dist[next.num]) {
                    dist[next.num] = node.cost + next.cost;
                    pq.add(new Node(next.num, dist[next.num]));
                }
            }
        }

        sb.append(dist[D]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
