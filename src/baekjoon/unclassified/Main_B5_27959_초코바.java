package baekjoon.unclassified;

import java.io.*;
import java.util.*;

public class Main_B5_27959_초코바 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(M <= 100 * N ? "Yes" : "No");
    }
}
