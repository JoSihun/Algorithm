package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B2_13458_시험감독 {
    private static int[] A;
    private static int N, B, C;
    private static long answer;


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

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = N;
        for (int i = 0; i < N; i++) {
            answer += Math.max(0, A[i] - B) / C;
            if (Math.max(0, A[i] - B) % C > 0)
                answer++;
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
