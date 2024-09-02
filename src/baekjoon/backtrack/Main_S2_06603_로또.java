package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S2_06603_로또 {
    public static int K;
    public static int[] S, result;
    public static StringBuilder sb;

    public static void combination(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            result[depth] = S[i];
            combination(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;

            S = new int[K];
            for (int i = 0; i < K; i++)
                S[i] = Integer.parseInt(st.nextToken());

            result = new int[6];
            combination(0, 0);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
