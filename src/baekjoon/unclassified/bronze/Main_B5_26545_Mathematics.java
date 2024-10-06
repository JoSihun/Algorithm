package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_26545_Mathematics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0, N = Integer.parseInt(br.readLine());
        while (N-- > 0) answer += Integer.parseInt(br.readLine());
        System.out.println(answer);
    }
}
