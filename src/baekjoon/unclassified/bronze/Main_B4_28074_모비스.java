package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_28074_모비스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean isPossible = true;
        for (char ch : "MOBIS".toCharArray()) {
            if (input.indexOf(ch) == -1) {
                isPossible = false;
                break;
            }
        }
        System.out.println(isPossible ? "YES" : "NO");
    }
}
