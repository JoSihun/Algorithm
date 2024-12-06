package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_30868_개표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N / 5; i++) sb.append("++++ ");
            for (int i = 0; i < N % 5; i++) sb.append("|");
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
