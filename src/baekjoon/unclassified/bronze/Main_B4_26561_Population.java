package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_26561_Population {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            sb.append(p + t / 4 - t / 7).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
