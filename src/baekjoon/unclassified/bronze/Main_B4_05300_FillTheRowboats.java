package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_05300_FillTheRowboats {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(" ");
            if (i % 6 == 0) sb.append("Go! ");
        }
        if (N % 6 != 0) sb.append("Go!");
        System.out.println(sb.toString().trim());
    }
}
