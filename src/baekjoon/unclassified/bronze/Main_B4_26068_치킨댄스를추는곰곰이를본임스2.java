package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_26068_치킨댄스를추는곰곰이를본임스2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++)
            if (Integer.parseInt(br.readLine().substring(2)) <= 90)
                answer++;
        System.out.println(answer);
    }
}
