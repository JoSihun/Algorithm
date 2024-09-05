package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S2_10971_외판원순회2 {
    public static int N;
    public static int answer;
    public static int[][] map;
    public static boolean[] visited;

    public static void backtrack(int start, int cur, int cost, int depth) {
        if (depth == N) {
            if (map[cur][start] != 0)
                answer = Math.min(answer, cost + map[cur][start]);
            return;
        }

        for (int next = 0; next < N; next++) {
            if (visited[next] || map[cur][next] == 0) continue;
            visited[next] = true;
            backtrack(start, next, cost + map[cur][next], depth + 1);
            visited[next] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        visited[0] = true;
        answer = Integer.MAX_VALUE;
        backtrack(0, 0, 0, 1);

        bw.write(answer + "\n");
        bw.flush();
    }
}
