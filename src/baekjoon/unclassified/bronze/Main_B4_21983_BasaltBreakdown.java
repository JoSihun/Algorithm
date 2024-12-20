package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B4_21983_BasaltBreakdown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(6 * Math.sqrt((2 * Long.parseLong(br.readLine())) / (3 * Math.sqrt(3))));
    }
}
