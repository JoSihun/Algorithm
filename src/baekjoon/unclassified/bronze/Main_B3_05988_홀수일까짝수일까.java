package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B3_05988_홀수일까짝수일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String num = br.readLine();
            sb.append((num.charAt(num.length() - 1)) % 2 == 0 ? "even" : "odd").append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
