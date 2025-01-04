package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B3_06131_완전제곱수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int B = 1; B <= 500; B++) {
            int A = (int) Math.sqrt(B * B + N);
            if (A * A == B * B + N) answer++;
        }
        System.out.println(answer);
    }
}
