package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_S2_18352_특정거리의도시찾기 {

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
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.cost > dist[node.num]) continue;
            for (int next : graph.get(node.num)) {
                if (dist[node.num] + 1 < dist[next]) {
                    dist[next] = dist[node.num] + 1;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }

        int answer = -1;
        for (int i = 1; i < N + 1; i++) {
            if (dist[i] == K) {
                answer = i;
                sb.append(i).append("\n");
            }
        }

        if (answer == -1) sb.append(-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
