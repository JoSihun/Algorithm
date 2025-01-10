package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_10174_팰린드롬 {
    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right)
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0)
            sb.append(isPalindrome(br.readLine().toLowerCase()) ? "Yes" : "No").append("\n");
        System.out.println(sb.toString().trim());
    }
}
