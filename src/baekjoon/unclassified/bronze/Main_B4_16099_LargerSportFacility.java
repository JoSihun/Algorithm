package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_16099_LargerSportFacility {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long lt = Long.parseLong(st.nextToken());
            long wt = Long.parseLong(st.nextToken());
            long le = Long.parseLong(st.nextToken());
            long we = Long.parseLong(st.nextToken());
            long areaTelecom = lt * wt; long areaEurecom = le * we;
            sb.append(areaTelecom == areaEurecom ? "Tie"
                    : areaTelecom < areaEurecom ? "Eurecom"
                    : "TelecomParisTech").append("\n");
        }

        System.out.print(sb);
    }
}
