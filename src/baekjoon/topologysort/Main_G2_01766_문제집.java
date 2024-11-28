package baekjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G2_01766_문제집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            inDegree[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int node = 1; node < N + 1; node++)
            if (inDegree[node] == 0) pq.add(node);

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int node = pq.poll();
            sb.append(node).append(" ");

            for (int next : graph[node]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
