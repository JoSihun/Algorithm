package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_29790_임스의메이플컵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean condition1 = N >= 1000;
        boolean condition2 = U >= 8000 || L >= 260;
        System.out.println(condition1 ? condition2 ? "Very Good" : "Good" : "Bad");
    }
}
