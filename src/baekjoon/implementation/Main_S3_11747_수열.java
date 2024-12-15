package baekjoon.implementation;

import java.io.*;

public class Main_S3_11747_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (sb.toString().length() < N)
            sb.append(br.readLine().replace(" ", ""));

        int answer = 0;
        String sequence = sb.toString();
        while (sequence.contains(String.valueOf(answer))) answer++;
        System.out.println(answer);
    }
}
