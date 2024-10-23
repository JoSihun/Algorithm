package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B5_29863_ArnosSleepSchedule {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        System.out.println((24 - S + E) % 24);
    }
}
