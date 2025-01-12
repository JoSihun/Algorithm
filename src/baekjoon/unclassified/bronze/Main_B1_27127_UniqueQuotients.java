package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_27127_UniqueQuotients {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = {"57429", "58239", "75249", "95742", "95823", "97524"};
        String[] B = {"06381", "06471", "08361", "10638", "10647", "10836"};
        int N = Integer.parseInt(br.readLine()) - 1;
        System.out.println(A[N] + " " + B[N]);
    }
}
