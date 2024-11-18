package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_28097_모범생포닉스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int answer = (N - 1) * 8;
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) answer += Integer.parseInt(st.nextToken());
        System.out.println(answer / 24 + " " + answer % 24);
    }
}
