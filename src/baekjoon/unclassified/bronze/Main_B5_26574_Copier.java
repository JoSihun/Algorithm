package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_26574_Copier {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(num).append(" ").append(num).append("\n");
        }
        System.out.print(sb);
    }
}
