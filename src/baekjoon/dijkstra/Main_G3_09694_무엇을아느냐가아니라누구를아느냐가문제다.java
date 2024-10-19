package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G3_09694_무엇을아느냐가아니라누구를아느냐가문제다 {
    public static int N, M;
    public static int[] dist;
    public static int[] track;
    public static List<List<Node>> graph;

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
        dist = new int[M]; track = new int[M];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(track, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Node next : graph.get(cur.num)) {
                if (cur.cost + next.cost < dist[next.num]) {
                    track[next.num] = cur.num;
                    dist[next.num] = cur.cost + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < M; i++)
                graph.add(new ArrayList<>());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph.get(x).add(new Node(y, z));
                graph.get(y).add(new Node(x, z));
            }

            dijkstra();

            sb.append("Case #").append(tc).append(": ");
            if (dist[M - 1] == Integer.MAX_VALUE) {
                sb.append("-1");
            } else {
                List<Integer> path = new ArrayList<>();
                for (int node = M - 1; node != -1; node = track[node])
                    path.add(node);

                Collections.reverse(path);
                for (int node : path)
                    sb.append(node).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
