package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_06888_TermsofOffice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int year = X; year <= Y; year += 4 * 3 * 5)
            sb.append("All positions change in year ").append(year).append("\n");
        System.out.println(sb.toString().trim());
    }
}
