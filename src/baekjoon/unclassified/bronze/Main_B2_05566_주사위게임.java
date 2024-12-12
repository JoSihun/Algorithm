package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main_B2_05566_주사위게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            board[i] = Integer.parseInt(br.readLine());

        int[] dice = new int[M];
        for (int i = 0; i < M; i++)
            dice[i] = Integer.parseInt(br.readLine());

        int position = 1, answer = 0;
        for (int roll : dice) {
            answer++;
            position += roll;
            if (position >= N) break;

            position += board[position];
            if (position >= N) break;
        }
        System.out.println(answer);
    }
}
