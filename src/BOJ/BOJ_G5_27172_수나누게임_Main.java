package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G5_27172_수나누게임_Main {
    private static int N;
    private static int[] x;

    private static int[] score;
    private static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        x = new int[N + 1];
        cards = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            cards[x[i]] = i;
        }

        score = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = x[i] * 2; j < 1000001; j += x[i]) {
                if (cards[j] != 0) {
                    score[i]++;
                    score[cards[j]]--;
                }
            }
        }

        for (int i = 1; i < N + 1; i++)
            sb.append(score[i]).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
