package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B3_15667_2018연세대학교프로그래밍경진대회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;
        System.out.println((int) Math.sqrt(N));
    }
}
