package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_30999_민주주의 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int majority = M / 2 + 1;

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String votes = br.readLine();

            int count = 0;
            for (int j = 0; j < M; j++) {
                if (votes.charAt(j) == 'O') count++;

                if (count > M / 2) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
