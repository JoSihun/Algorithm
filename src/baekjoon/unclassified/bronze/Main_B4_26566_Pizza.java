package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_26566_Pizza {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A1 = Integer.parseInt(st.nextToken());
            int P1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int R1 = Integer.parseInt(st.nextToken());
            int P2 = Integer.parseInt(st.nextToken());

            sb.append((double) A1 / P1 > Math.PI * R1 * R1 / P2
                    ? "Slice of pizza" : "Whole pizza").append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
