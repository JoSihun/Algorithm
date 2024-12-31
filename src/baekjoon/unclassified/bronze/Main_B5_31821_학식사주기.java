package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_31821_학식사주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N];
        for (int i = 0; i < N; i++)
            price[i] = Integer.parseInt(br.readLine());

        int answer = 0;
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++)
            answer += price[Integer.parseInt(br.readLine()) - 1];

        System.out.println(answer);
    }
}
