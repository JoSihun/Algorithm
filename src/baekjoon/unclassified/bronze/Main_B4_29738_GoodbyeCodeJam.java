package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_29738_GoodbyeCodeJam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("Case #").append(tc).append(": ");

            if (N > 4500) sb.append("Round 1");
            else if (N > 1000) sb.append("Round 2");
            else if (N > 25) sb.append("Round 3");
            else sb.append("World Finals");
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
