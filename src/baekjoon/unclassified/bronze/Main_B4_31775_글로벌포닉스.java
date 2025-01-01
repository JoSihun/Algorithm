package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_B4_31775_글로벌포닉스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>(Arrays.asList('l', 'k', 'p'));

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            if (!input.isEmpty())
                set.remove(input.charAt(0));
        }

        System.out.println(set.isEmpty() ? "GLOBAL" : "PONIX");
    }
}
