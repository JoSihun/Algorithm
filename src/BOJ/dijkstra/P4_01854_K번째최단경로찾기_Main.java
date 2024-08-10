package BOJ.dijkstra;

import java.io.*;
import java.util.*;

public class P4_01854_K번째최단경로찾기_Main {

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
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][k + 1];
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : graph.get(cur.num)) {
                if (cur.cost + next.cost < dist[next.num][k]) {
                    dist[next.num][k] = cur.cost + next.cost;
                    pq.offer(new Node(next.num, dist[next.num][k]));
                    Arrays.sort(dist[next.num]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++)
            sb.append(dist[i][k - 1] == Integer.MAX_VALUE ? -1 : dist[i][k - 1]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
