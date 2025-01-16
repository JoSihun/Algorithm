package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_25858_DivideTheCash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] solved = new int[N];
        for (int i = 0; i < N; i++) {
            solved[i] = Integer.parseInt(br.readLine());
            sum += solved[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append((solved[i] * D) / sum).append("\n");
        System.out.println(sb.toString().trim());
    }
}
