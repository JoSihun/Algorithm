package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_10480_Oddities {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int X = Integer.parseInt(br.readLine());
            sb.append(X).append(X % 2 == 0 ? " is even" : " is odd").append("\n");
        }
        System.out.println(sb);
    }
}
