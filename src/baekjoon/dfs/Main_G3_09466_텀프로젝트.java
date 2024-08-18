package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G3_09466_텀프로젝트 {
    public static int N, count;
    public static int[] students;
    public static boolean[] cycled;
    public static boolean[] visited;

    public static void dfs(int cur) {
        visited[cur] = true;
        int next = students[cur];

        if (!visited[next]) {
            dfs(next);
        } else if (!cycled[next]) {
            int num = next;
            while (num != cur) {
                count++;
                num = students[num];
            }
            count++;
        }
        cycled[cur] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            students = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++)
                students[i] = Integer.parseInt(st.nextToken());

            count = 0;
            cycled = new boolean[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i < N + 1; i++)
                if (!visited[i]) dfs(i);
            sb.append(N - count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
