package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_G5_14284_간선이어가기2 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S, 0));
        dist[S] = 0;

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

        bw.write(String.valueOf(dist[T]));
        bw.flush();
    }
}
