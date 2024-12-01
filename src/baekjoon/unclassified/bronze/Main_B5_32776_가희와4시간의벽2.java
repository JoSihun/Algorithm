package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_32776_가희와4시간의벽2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Sab = Integer.parseInt(br.readLine());
        int Fab = Integer.parseInt(br.readLine());
        System.out.println(Sab <= 240 && Sab <= Fab ? "high speed rail" : "flight");
    }
}
