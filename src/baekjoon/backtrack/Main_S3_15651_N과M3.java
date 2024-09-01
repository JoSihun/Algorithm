package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S3_15651_N과M3 {
    public static int N, M;
    public static int[] selected;
    public static StringBuilder sb;

    public static void backtrack(int depth) {
        if (depth == M) {
            for (int num : selected)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            selected[depth] = i;
            backtrack(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        selected = new int[M];
        backtrack(0);

        bw.write(sb.toString());
        bw.flush();
    }
}
