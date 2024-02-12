package SWEA2024B;

import java.io.*;

public class Solution_No1_1288_새로운불면증치료법 {
    private static final int mask = (1 << 10) - 1;
    private static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            int count = 1;
            int visited = 0;
            while (visited != mask) {
                int num = count * N;
                while (num > 0) {
                    visited = visited | 1 << (num % 10);
                    num = num / 10;
                }
                answer = N * count++;
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
