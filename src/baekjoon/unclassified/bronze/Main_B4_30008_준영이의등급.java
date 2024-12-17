package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

public class Main_B4_30008_준영이의등급 {
    private static int getGrade(int P) {
        if (P <= 4) return 1;
        else if (P <= 11) return 2;
        else if (P <= 23) return 3;
        else if (P <= 40) return 4;
        else if (P <= 60) return 5;
        else if (P <= 77) return 6;
        else if (P <= 89) return 7;
        else if (P <= 96) return 8;
        else return 9;
    }

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int score = Integer.parseInt(st.nextToken());
            sb.append(getGrade(score * 100 / N)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
