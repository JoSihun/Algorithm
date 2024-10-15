package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_27219_로빈슨크루소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N / 5; i++) answer.append("V");
        for (int i = 0; i < N % 5; i++) answer.append("I");
        System.out.println(answer);
    }
}
