package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_25640_MBTI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String jinho = br.readLine();

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) if (br.readLine().equals(jinho)) answer++;
        System.out.println(answer);
    }
}
