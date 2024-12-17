package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B4_28224_FinalPrice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        while (N-- > 0) answer += Integer.parseInt(br.readLine());
        System.out.println(answer);
    }
}
