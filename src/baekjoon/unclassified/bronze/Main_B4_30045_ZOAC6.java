package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/30045
public class Main_B4_30045_ZOAC6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String sentence = br.readLine();
            if (sentence.contains("01") || sentence.contains("OI"))
                answer++;
        }
        System.out.println(answer);
    }
}
