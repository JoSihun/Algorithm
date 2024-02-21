package SWEA.PRO.LECTURE2024;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_No2_10726_이진수표현 {
    private static int N, M;
    private static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int mask = (1 << N) - 1;
            answer = (M & mask) == mask ? "ON" : "OFF";
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
