package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_10025_게으른백곰 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] bucket = new int[1_000_001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            bucket[x] += g;     // 1)
            bucket[x] = g;      // 2)
        }

        int answer = 0;
        int window = 2 * K + 1;
        for (int i = 0; i < Math.min(window, 1_000_001); i++)
            answer += bucket[i];

        int temp = answer;
        for (int i = window; i <= 1_000_000; i++) {
            temp += bucket[i] - bucket[i - window];
            answer = Math.max(temp, answer);
        }
        System.out.println(answer);
    }
}
