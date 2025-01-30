package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/31867
public class Main_B4_31867_홀짝홀짝 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int countOdd = 0;
        int countEven = 0;
        for (char c : br.readLine().toCharArray()) {
            if ((c - '0') % 2 == 0) countEven++; else countOdd++;
        }
        System.out.println(countOdd < countEven ? 0 : countOdd > countEven ? 1 : -1);
    }
}
