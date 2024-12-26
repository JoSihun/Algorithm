package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_26350_GoodCoinDenomination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int d = Integer.parseInt(st.nextToken());

            boolean isGoodDenomination = true;
            int prev = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                if (prev * 2 > cur) isGoodDenomination = false;
                prev = cur;
            }

            sb.append("Denominations: ").append(line.substring(d == 10 ? 3 : 2)).append("\n");
            sb.append(isGoodDenomination ? "Good coin denominations!" : "Bad coin denominations!").append("\n\n");
        }
        System.out.println(sb);
    }
}
