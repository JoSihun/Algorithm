package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_32775_가희와4시간의벽1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Sab = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int Ma = Integer.parseInt(st.nextToken());
        int Fab = Integer.parseInt(st.nextToken());
        int Mb = Integer.parseInt(st.nextToken());

        System.out.println(Sab <= Ma + Fab + Mb || Sab <= 240  ? "high speed rail" : "flight");
    }
}
