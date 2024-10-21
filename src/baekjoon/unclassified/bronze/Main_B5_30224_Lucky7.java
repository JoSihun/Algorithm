package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B5_30224_Lucky7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        boolean contains = N.contains("7");
        boolean divisible = Long.parseLong(N) % 7 == 0;
        System.out.println(!contains ? (!divisible ? 0 : 1) : (!divisible ? 2 : 3));
    }
}
