package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_25991_LotsOfLiquid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) sum += Math.pow(Double.parseDouble(st.nextToken()), 3);
        System.out.println(Math.cbrt(sum));
    }
}
