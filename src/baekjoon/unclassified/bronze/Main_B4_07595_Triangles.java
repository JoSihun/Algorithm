package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_07595_Triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= i; j++)
                    sb.append("*");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
