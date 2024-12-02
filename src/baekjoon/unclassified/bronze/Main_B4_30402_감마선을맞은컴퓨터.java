package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_30402_감마선을맞은컴퓨터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            for (char ch : br.readLine().toCharArray()) {
                if (ch == 'w') {
                    System.out.print("chunbae");
                    return;
                } else if (ch == 'b') {
                    System.out.print("nabi");
                    return;
                } else if (ch == 'g') {
                    System.out.print("yeongcheol");
                    return;
                }
            }
        }
    }
}
