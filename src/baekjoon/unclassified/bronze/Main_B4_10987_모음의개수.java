package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_10987_모음의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vowels = "aeiou"; int answer = 0;
        for (char ch : br.readLine().toCharArray())
            if (vowels.indexOf(ch) != -1) answer++;
        System.out.println(answer);
    }
}
