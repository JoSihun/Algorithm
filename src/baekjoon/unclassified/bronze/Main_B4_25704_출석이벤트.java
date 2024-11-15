package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_25704_출석이벤트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int answer = P;
        if (N >= 5) answer = Math.min(answer, P - 500);
        if (N >= 10) answer = Math.min(answer, (int) (P * 0.9));
        if (N >= 15) answer = Math.min(answer, P - 2000);
        if (N >= 20) answer = Math.min(answer, (int) (P * 0.75));
        System.out.println(Math.max(0, answer));
    }
}
