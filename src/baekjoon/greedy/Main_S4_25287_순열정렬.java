package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main_S4_25287_순열정렬 {
    private static boolean isValid(int N, int[] arr) {
        int prev = 0;
        for (int i1 : arr) {
            int i2 = N - i1 + 1;
            if (i1 < prev && i2 < prev) return false;

            if (prev <= i1 && prev <= i2) prev = Math.min(i1, i2);
            else if (prev <= i1) prev = i1;
            else if (prev <= i2) prev = i2;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            sb.append(isValid(N, arr) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
