package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B4_09295_주사위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append("Case ").append(tc).append(": ").append(a + b).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
