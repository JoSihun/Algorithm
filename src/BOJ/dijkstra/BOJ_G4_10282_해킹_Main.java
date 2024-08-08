package BOJ.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ_G4_10282_해킹_Main {

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

        int TC = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            List<List<Node>> graph = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Node(a, s));
            }

            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(C, 0));
            dist[C] = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cur.cost > dist[cur.num]) continue;

                for (Node next : graph.get(cur.num)) {
                    if (dist[cur.num] + next.cost < dist[next.num]) {
                        dist[next.num] = dist[cur.num] + next.cost;
                        pq.offer(new Node(next.num, dist[next.num]));
                    }
                }
            }

            int time = 0, count = 0;
            for (int i = 1; i < N + 1; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    time = Math.max(time, dist[i]);
                    count++;
                }
            }
            sb.append(count).append(" ").append(time).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
