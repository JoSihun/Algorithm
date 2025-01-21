package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_26736_WynikMeczu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int A = 0;
        for (char c : input.toCharArray())
            if (c == 'A') A++;

        System.out.println(A + " : " + (input.length() - A));
    }
}
