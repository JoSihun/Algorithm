package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_31429_SUAPC2023Summer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] scores = new int[12][2];
        scores[1] = new int[]{ 12, 1600 };
        scores[2] = new int[]{ 11, 894 };
        scores[3] = new int[]{ 11, 1327 };
        scores[4] = new int[]{ 10, 1311 };
        scores[5] = new int[]{ 9, 1004 };
        scores[6] = new int[]{ 9, 1178 };
        scores[7] = new int[]{ 9, 1357 };
        scores[8] = new int[]{ 8, 837 };
        scores[9] = new int[]{ 7, 1055 };
        scores[10] = new int[]{ 6, 556 };
        scores[11] = new int[]{ 6, 773 };

        int N = Integer.parseInt(br.readLine());
        System.out.println(scores[N][0] + " " + scores[N][1]);
    }
}
