package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_P4_13907_세금 {
    public static int S, D;
    public static int N, M, K;
    public static int[][] dist;
    public static List<List<Node>> graph;

    public static class Node implements Comparable<Node> {
        public int num, cnt, cost;

        public Node(int num, int cost) {
            this.cnt = 0;
            this.num = num;
            this.cost = cost;
        }

        public Node(int num, int cost, int cnt) {
            this.cnt = cnt;
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void dijkstra() {
        dist = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S, 0, 0));
        dist[S][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.num == D) continue;
            if (cur.cost > dist[cur.num][cur.cnt]) continue;

            for (Node next : graph.get(cur.num)) {
                boolean flag = false;
                for (int cnt = cur.cnt; cnt > 0; cnt--) {
                    if (cur.cost + next.cost > dist[next.num][cnt]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;

                if (cur.cnt + 1 > N) continue;
                if (cur.cost + next.cost < dist[next.num][cur.cnt + 1]) {
                    dist[next.num][cur.cnt + 1] = cur.cost + next.cost;
                    pq.offer(new Node(next.num, dist[next.num][cur.cnt + 1], cur.cnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        dijkstra();
        int answer = Integer.MAX_VALUE;
        for (int cnt = 0; cnt < N + 1; cnt++)
            answer = Math.min(answer, dist[D][cnt]);
        sb.append(answer).append("\n");

        int cumIncreaseTax = 0;
        for (int i = 0; i < K; i++) {
            cumIncreaseTax += Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            for (int cnt = 0; cnt < N + 1; cnt++)
                if (dist[D][cnt] != Integer.MAX_VALUE)
                    answer = Math.min(answer, dist[D][cnt] + cnt * cumIncreaseTax);
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
