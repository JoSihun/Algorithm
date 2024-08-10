package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S1_14888_연산자끼워넣기 {
    private static int[] A, op;
    private static int N, max, min;

    public static void dfs(int result, int idx) {
        if (idx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0: dfs(result + A[idx], idx + 1); break;
                    case 1: dfs(result - A[idx], idx + 1); break;
                    case 2: dfs(result * A[idx], idx + 1); break;
                    case 3: dfs(result / A[idx], idx + 1); break;
                }
                op[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            op[i] = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(A[0], 1);

        sb.append(max).append("\n");
        sb.append(min).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
