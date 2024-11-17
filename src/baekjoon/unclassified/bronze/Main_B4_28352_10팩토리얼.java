package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_28352_10팩토리얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long factorial = 1;
        for (int num = 2; num <= N; num++) factorial *= num;
        System.out.println(factorial / (60 * 60 * 24 * 7));
//        long[] factorial = new long[N + 1];
//        factorial[0] = factorial[1] = 1;
//        for (int num = 2; num <= N; num++)
//            factorial[num] = factorial[num - 1] * num;
//
//        int week = 60 * 60 * 24 * 7;
//        System.out.println(factorial[N] / week);
    }
}
