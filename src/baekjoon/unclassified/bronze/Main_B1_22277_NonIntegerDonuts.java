package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_22277_NonIntegerDonuts {
    private static int parseMoney(String value) {
        return (int) Math.round(Double.parseDouble(value.replace("$", "")) * 100);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int balance = parseMoney(br.readLine());
        for (int i = 0; i < N; i++) {
            balance += parseMoney(br.readLine());
            if (balance % 100 != 0) answer++;
        }

        System.out.println(answer);
    }
}
