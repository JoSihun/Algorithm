package baekjoon.backtrack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_15664_N과M10 {
    public static int N, M;
    public static int[] numbers;
    public static int[] selected;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void backtrack(int start, int depth) {
        if (depth == M) {
            for (int num : selected)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = start; i < N; i++) {
            if (visited[i] || numbers[i] == prev) continue;
            visited[i] = true;
            prev = numbers[i];
            selected[depth] = numbers[i];
            backtrack(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        selected = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();
        backtrack(0, 0);

        bw.write(sb.toString());
        bw.flush();
    }
}
