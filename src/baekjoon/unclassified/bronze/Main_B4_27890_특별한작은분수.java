package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

public class Main_B4_27890_특별한작은분수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        while (N-- > 0) x = x % 2 == 0 ? (x / 2) ^ 6 : (2 * x) ^ 6;
        System.out.println(x);
    }
}
