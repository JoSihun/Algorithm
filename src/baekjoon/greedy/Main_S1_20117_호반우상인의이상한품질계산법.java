package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_20117_호반우상인의이상한품질계산법 {
    private static int N;
    private static int[] a;
    private static int answer;

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        for (int i = 0; i < N / 2; i++)
            answer += a[N - 1 - i] * 2;
        if (N % 2 == 1)
            answer += a[N / 2];

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
