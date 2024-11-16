package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_27310_chino_shock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] emoji = br.readLine().toCharArray();

        int underscore = 0;
        for (char ch : emoji) if (ch == '_') underscore++;
        System.out.println(emoji.length + 2 + underscore * 5);
    }
}
