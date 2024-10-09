package baekjoon.unclassified.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_02473_세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);
        long sum = Long.MAX_VALUE;
        long answer1 = 0, answer2 = 0, answer3 = 0;

        for (int i = 0; i < N - 2; i++) {
            int pointer1 = i + 1;
            int pointer2 = N - 1;

            while (pointer1 < pointer2) {
                long newSum = arr[i] + arr[pointer1] + arr[pointer2];

                if (Math.abs(newSum) < Math.abs(sum)) {
                    sum = newSum;
                    answer1 = arr[i];
                    answer2 = arr[pointer1];
                    answer3 = arr[pointer2];
                }

                if (newSum < 0) {
                    pointer1++;
                } else {
                    pointer2--;
                }
            }
        }

        bw.write(answer1 + " " + answer2 + " " + answer3);
        bw.flush();
    }
}
