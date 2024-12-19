package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

public class Main_B4_13221_Manhattan {
    public static class Node implements Comparable<Node> {
        int x, y, dist;
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Math.abs(sx - x) + Math.abs(sy - y);
            pq.offer(new Node(x, y, dist));
        }
        Node answer = pq.poll();
        System.out.println(answer.x + " " + answer.y);
    }
}
