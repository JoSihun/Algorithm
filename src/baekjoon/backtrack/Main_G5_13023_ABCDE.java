package baekjoon.backtrack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G5_13023_ABCDE {
    public static int N, M;
    public static boolean found;
    public static boolean[] visited;
    public static List<List<Integer>> graph;

    public static void backtrack(int cur, int depth) {
        if (found) return;
        if (depth == 5) {
            found = true;
            return;
        }

        visited[cur] = true;
        for (int next : graph.get(cur)) {
            if (visited[next]) continue;
            backtrack(next, depth + 1);
        }
        visited[cur] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int start = 0; start < N; start++) {
            visited = new boolean[N];
            backtrack(start, 1);
            if (found) break;
        }

        bw.write(String.valueOf(found ? 1 : 0));
        bw.flush();
    }
}
