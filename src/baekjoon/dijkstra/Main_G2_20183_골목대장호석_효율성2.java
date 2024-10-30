package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G2_20183_골목대장호석_효율성2 {
    public static long C;
    public static int N, M, A, B;
    public static List<Edge>[] graph;

    public static class Edge implements Comparable<Edge> {
        public int num;
        public long cost;
        public long maxCost;

        public Edge(int num, long cost, long maxCost) {
            this.num = num;
            this.cost = cost;
            this.maxCost = maxCost;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.maxCost == o.maxCost)
                return Long.compare(this.cost, o.cost);
            return Long.compare(this.maxCost, o.maxCost);
        }
    }

    public static long dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(A, 0L, 0L));

        long[] maxCost = new long[N];
        Arrays.fill(maxCost, Long.MAX_VALUE);

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.num == B) return cur.maxCost;

            for (Edge next : graph[cur.num]) {
                if (cur.cost + next.cost > C) continue;

                // 현재까지 경로 중 한 골목을 지나는 최대 비용
                long newCost = cur.cost + next.cost;
                long newMaxCost = Math.max(cur.maxCost, next.cost);

                // 이 최대 비용이 작아야함
                if (newMaxCost < maxCost[next.num]) {
                    maxCost[next.num] = newMaxCost;
                    pq.offer(new Edge(next.num, newCost, newMaxCost));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;
        C = Long.parseLong(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            long c = Long.parseLong(st.nextToken());
            graph[a].add(new Edge(b, c, 0L));
            graph[b].add(new Edge(a, c, 0L));
        }

        System.out.println(dijkstra());
    }
}

//public class Main_G2_20183_골목대장호석_효율성2 {
//    public static int N, M, A, B;
//    public static long C;
//    public static List<Edge>[] graph;
//
//    public static class Edge implements Comparable<Edge> {
//        public int num;
//        public long cost;
//
//        public Edge(int num, long cost) {
//            this.num = num;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Edge o) {
//            return Long.compare(this.cost, o.cost);
//        }
//    }
//
//    public static boolean dijkstra(int limit) {
//        long[] dist = new long[N];
//        Arrays.fill(dist, Long.MAX_VALUE);
//
//        PriorityQueue<Edge> pq = new PriorityQueue<>();
//        pq.offer(new Edge(A, 0));
//        dist[A] = 0;
//
//        while (!pq.isEmpty()) {
//            Edge cur = pq.poll();
//            if (cur.cost > dist[cur.num]) continue;
//
//            for (Edge next : graph[cur.num]) {
//                if (next.cost > limit) continue;
//                if (cur.cost + next.cost < dist[next.num]) {
//                    dist[next.num] = cur.cost + next.cost;
//                    pq.offer(new Edge(next.num, dist[next.num]));
//                }
//            }
//        }
//
//        return dist[B] <= C;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        A = Integer.parseInt(st.nextToken()) - 1;
//        B = Integer.parseInt(st.nextToken()) - 1;
//        C = Long.parseLong(st.nextToken());
//
//        graph = new ArrayList[N];
//        for (int i = 0; i < N; i++)
//            graph[i] = new ArrayList<>();
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken()) - 1;
//            int b = Integer.parseInt(st.nextToken()) - 1;
//            int c = Integer.parseInt(st.nextToken());
//            graph[a].add(new Edge(b, c));
//            graph[b].add(new Edge(a, c));
//        }
//
//        int answer = -1;
//        int left = 0, right = 1_000_000_000;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (dijkstra(mid)) {
//                answer = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        System.out.println(answer);
//    }
//}
