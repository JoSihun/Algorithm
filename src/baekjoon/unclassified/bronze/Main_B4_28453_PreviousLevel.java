package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_28453_PreviousLevel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            levels[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int level : levels) {
            if (level == 300) {
                sb.append(1).append(" ");
            } else if (level >= 275) {
                sb.append(2).append(" ");
            } else if (level >= 250) {
                sb.append(3).append(" ");
            } else {
                sb.append(4).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
