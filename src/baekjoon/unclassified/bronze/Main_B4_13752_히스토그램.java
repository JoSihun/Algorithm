package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_13752_히스토그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) sb.append('=');
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
