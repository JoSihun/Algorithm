package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

/* https://www.acmicpc.net/problem/30017 */
public class Main_B4_30017_치즈버거만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken());
        System.out.println(Math.min(A, B) * 2 + 1);
    }
}
