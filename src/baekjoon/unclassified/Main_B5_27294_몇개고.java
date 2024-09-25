package baekjoon.unclassified;

import java.io.*;
import java.util.*;

public class Main_B5_27294_몇개고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        System.out.println(12 <= T && T <= 16 && S == 0 ? 320 : 280);
    }
}
