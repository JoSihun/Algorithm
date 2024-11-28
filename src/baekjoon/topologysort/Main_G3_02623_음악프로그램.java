package baekjoon.topologysort;

import java.io.*;
import java.util.*;

public class Main_G3_02623_음악프로그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            int[] singers = new int[K];
            for (int j = 0; j < K; j++)
                singers[j] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K - 1; j++) {
                int a = singers[j];
                int b = singers[j + 1];
                graph.get(a).add(b);
                indegree[b]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++)
            if (indegree[i] == 0)
                queue.offer(i);

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            answer.add(cur);

            for (int next : graph.get(cur)) {
                if (--indegree[next] == 0)
                    queue.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (answer.size() == N) {
            for (int singer : answer)
                sb.append(singer).append("\n");
        } else {
            sb.append(0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
