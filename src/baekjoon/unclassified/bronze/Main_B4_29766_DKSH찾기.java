package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_29766_DKSH찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;
        for (int i = 0; i <= input.length() - 4; i++)
            if (input.startsWith("DKSH", i)) answer++;
        System.out.println(answer);
    }
}
