package baekjoon.topology_sort;

import java.io.*;
import java.util.*;

public class Main_G3_01005_ACMCraft {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            graph.add(new ArrayList<>());

            int[] buildTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
                graph.add(new ArrayList<>());
            }

            int[] degree = new int[N + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph.get(X).add(Y);
                degree[Y]++;
            }

            int[] dp = new int[N + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i < N + 1; i++) {
                dp[i] = buildTime[i];
                if (degree[i] == 0)
                    queue.offer(i);
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph.get(cur)) {
                    dp[next] = Math.max(dp[cur] + buildTime[next], dp[next]);
                    if (--degree[next] == 0)
                        queue.offer(next);
                }
            }

            int W = Integer.parseInt(br.readLine());
            sb.append(dp[W]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
