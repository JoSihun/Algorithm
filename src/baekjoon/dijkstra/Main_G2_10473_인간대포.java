package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G2_10473_인간대포 {
    public static int N;
    public static List<Edge>[] graph;

    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Point other) {
            return Math.hypot(this.x - other.x, this.y - other.y);
        }
    }

    public static class Edge implements Comparable<Edge> {
        public int num;
        public double cost;

        public Edge(int num, double cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    public static double dijkstra() {
        double[] dist = new double[N + 2];
        Arrays.fill(dist, Double.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Edge next : graph[cur.num]) {
                if (cur.cost + next.cost < dist[next.num]) {
                    dist[next.num] = cur.cost + next.cost;
                    pq.offer(new Edge(next.num, dist[next.num]));
                }
            }
        }

        return dist[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sx = Double.parseDouble(st.nextToken());
        double sy = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double ex = Double.parseDouble(st.nextToken());
        double ey = Double.parseDouble(st.nextToken());

        N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N + 2];
        points[0] = new Point(sx, sy);
        points[1] = new Point(ex, ey);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i + 2] = new Point(x, y);
        }

        graph = new ArrayList[N + 2];
        for (int i = 0; i < N + 2; i++)
            graph[i] = new ArrayList<>();

        for (int a = 0; a < N + 2; a++) {
            for (int b = 0; b < N + 2; b++) {
                if (a == b) continue;

                // 거리 = 속력 x 시간 | 시간 = 거리 / 속력
                double dist = points[a].distance(points[b]);
                double time = dist / 5.0;

                // Math.min(대포를 안 타는 경우, 대포를 타는 경우)
                if (a != 0 && a != 1)   // 출발지, 목적지는 대포가 아님
                    time = Math.min(time, 2 + Math.abs(dist - 50) / 5.0);

                graph[a].add(new Edge(b, time));
            }
        }

        System.out.println(dijkstra());
    }
}
