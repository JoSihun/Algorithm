package baekjoon.unclassified.bronze;

import java.io.*;

/* https://www.acmicpc.net/problem/5357 */
public class Main_B4_05357_Dedupe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char prev = '0';
            for (char ch : br.readLine().toCharArray()) {
                if (ch == prev) continue;
                sb.append(ch);
                prev = ch;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
