package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_25881_ElectricBill {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lowRate = Integer.parseInt(st.nextToken());
        int highRate = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int consumption = Integer.parseInt(br.readLine());
            int charge1 = Math.min(consumption, 1000) * lowRate;
            int charge2 = Math.max(consumption - 1000, 0) * highRate;
            sb.append(consumption).append(" ").append(charge1 + charge2).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
