package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class Main_G2_01167_트리의지름 {
    public static int V;
    public static int maxNode;
    public static int maxDist;
    public static boolean[] visited;
    public static List<List<Node>> graph;

    public static class Node {
        public int num, dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    public static void dfs(int node, int dist) {
        visited[node] = true;
        maxDist = Math.max(dist, maxDist);
        if (dist == maxDist) maxNode = node;

        for (Node next : graph.get(node)) {
            if (visited[next.num]) continue;
            dfs(next.num, dist + next.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;

                int c = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, c));
                graph.get(b).add(new Node(a, c));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);
        maxDist = 0;

        visited = new boolean[V + 1];
        dfs(maxNode, 0);
        System.out.println(maxDist);
    }
}
