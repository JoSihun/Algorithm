package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_29699_WelcomeToSMUPC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("WelcomeToSMUPC".charAt((Integer.parseInt(br.readLine()) - 1) % 14));
    }
}
