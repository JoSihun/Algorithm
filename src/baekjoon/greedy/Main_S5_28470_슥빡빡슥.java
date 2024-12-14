package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main_S5_28470_슥빡빡슥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        long answer = 0;
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st1.nextToken());
            int B = Integer.parseInt(st2.nextToken());
            double K = Double.parseDouble(st3.nextToken()) * 10;

            long attackFirst = (long) (A * K / 10) - B;
            long defendFirst = A - (long) (B * K / 10);
            answer += Math.max(attackFirst, defendFirst);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
