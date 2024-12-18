package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B4_29725_체스초보브실이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] score = new int[128];
        score['K'] = 0; score['k'] = 0;
        score['P'] = 1; score['p'] = -1;
        score['N'] = 3; score['n'] = -3;
        score['B'] = 3; score['b'] = -3;
        score['R'] = 5; score['r'] = -5;
        score['Q'] = 9; score['q'] = -9;

        int answer = 0;
        for (int i = 0; i < 8; i++)
            for (char c : br.readLine().toCharArray())
                answer += score[c];
        System.out.println(answer);
    }
}
