package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S2_01182_부분수열의합 {
    public static int N, S;
    public static int answer;
    public static int[] numbers;

    public static void backtrack(int index, int sum) {
        if (index == N) {
            if (sum == S) answer++;
            return;
        }

        backtrack(index + 1, sum);
        backtrack(index + 1, sum + numbers[index]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        backtrack(0, 0);
        if (S == 0) answer--;

        bw.write(answer + "\n");
        bw.flush();
    }
}
