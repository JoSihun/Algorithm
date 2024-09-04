package baekjoon.backtrack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_15656_N과M7 {
    public static int N, M;
    public static int[] numbers;
    public static int[] selected;
    public static StringBuilder sb;

    public static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            selected[depth] = numbers[i];
            backtrack(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        sb = new StringBuilder();
        backtrack(0);

        bw.write(sb.toString());
        bw.flush();
    }
}
