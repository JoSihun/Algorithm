package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_P5_01162_도로포장 {
    public static class Node implements Comparable<Node> {
        public int num, cnt;
        public long cost;

        public Node(int num, long cost, int cnt) {
            this.num = num;
            this.cnt = cnt;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, t, 0));
            graph.get(b).add(new Node(a, t, 0));
        }

        long[][] dist = new long[N + 1][K + 1];
        for (int i = 1; i < N + 1; i++)
            Arrays.fill(dist[i], Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num][cur.cnt]) continue;

            for (Node next : graph.get(cur.num)) {
                // 도로를 포장하지 않는 경우
                if (cur.cost + next.cost < dist[next.num][cur.cnt]) {
                    dist[next.num][cur.cnt] = cur.cost + next.cost;
                    pq.offer(new Node(next.num, cur.cost + next.cost, cur.cnt));
                }
                // 도로를 포장하는 경우
                if (cur.cnt < K && cur.cost < dist[next.num][cur.cnt + 1]) {
                    dist[next.num][cur.cnt + 1] = cur.cost;
                    pq.offer(new Node(next.num, cur.cost, cur.cnt + 1));
                }
            }
        }

        long answer = Long.MAX_VALUE;
        for (int k = 0; k <= K; k++)
            answer = Math.min(answer, dist[N][k]);

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
