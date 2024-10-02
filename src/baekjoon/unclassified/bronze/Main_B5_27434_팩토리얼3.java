package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_B5_27434_팩토리얼3 {
    public static BigInteger factorial(int start, int end) {
        if (start == end) return BigInteger.valueOf(start);
        if (start > end) return BigInteger.ONE;

        int mid = (start + end) / 2;
        return factorial(start, mid).multiply(factorial(mid + 1, end));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorial(1, Integer.parseInt(br.readLine())));
    }
}
