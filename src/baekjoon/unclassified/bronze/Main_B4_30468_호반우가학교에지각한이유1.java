package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_30468_호반우가학교에지각한이유1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 4; i++)
            sum += Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        System.out.println(Math.max(0, 4 * N - sum));
    }
}
