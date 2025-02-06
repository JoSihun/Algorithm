package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/25828
public class Main_B4_25828_CoronaVirusTesting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int individual = g * p, group = g + (t * p);
        System.out.println(individual == group ? 0 : individual < group ? 1 : 2);
    }
}
