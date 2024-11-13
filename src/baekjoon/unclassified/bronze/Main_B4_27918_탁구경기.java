package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_27918_탁구경기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int X = 0, Y = 0;
        while (N-- > 0 && Math.abs(X - Y) != 2) {
            String winner = br.readLine();
            if (winner.equals("D")) X++; else Y++;
        }
        System.out.println(X + ":" + Y);
    }
}
