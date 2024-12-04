package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B4_31090_2023은무엇이특별할까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append((N + 1) % (N % 100) == 0 ? "Good" : "Bye").append("\n");
        }
        System.out.print(sb);
    }
}
