package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_05341_Pyramids {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0)
            sb.append(n * (n + 1) / 2).append("\n");
        System.out.print(sb);
    }
}
