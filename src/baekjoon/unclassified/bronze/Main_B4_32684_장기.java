package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_32684_장기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[][] pieces = new int[2][6];
        for (int i = 0; i < 6; i++) {
            pieces[0][i] = Integer.parseInt(st1.nextToken());
            pieces[1][i] = Integer.parseInt(st2.nextToken());
        }

        int score1 = 0, score2 = 0;
        int[] scores = {13, 7, 5, 3, 3, 2};
        for (int i = 0; i < 6; i++) {
            score1 += pieces[0][i] * scores[i];
            score2 += pieces[1][i] * scores[i];
        }
        System.out.println(score1 > score2 + 1.5 ? "cocjr0208" : "ekwoo");
    }
}
