package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B1_19740_HowManyTests {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int max = 0, digits = 0;
        for (int i = 0; i < K; i++) {
            String num = br.readLine();
            digits = Math.max(digits, num.length());
            max = Math.max(max, Integer.parseInt(num));
        }

        int minTests = Math.max(max, (int) Math.pow(10, digits- 1));
        int maxTests = (int) Math.pow(10, digits) - 1;
        System.out.println(minTests + "\n" + maxTests);
    }
}
