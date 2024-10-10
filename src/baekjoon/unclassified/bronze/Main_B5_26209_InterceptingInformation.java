package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_26209_InterceptingInformation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            int N = Integer.parseInt(st.nextToken());
            if (N != 0 && N != 1) {
                System.out.println("F");
                return;
            }
        }
        System.out.println("S");
    }
}
