package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_31822_재수강 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String prefix = br.readLine().substring(0, 5);
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++)
            if (br.readLine().startsWith(prefix)) answer++;
        System.out.println(answer);
    }
}
