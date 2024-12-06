package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_31495_그게무슨코드니 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();

        System.out.println(size > 2 && input.charAt(0) == '"' && input.charAt(size - 1) == '"' ?
                input.substring(1, size - 1) : "CE");
    }
}
