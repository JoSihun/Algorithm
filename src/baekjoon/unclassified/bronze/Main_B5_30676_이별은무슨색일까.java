package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_30676_이별은무슨색일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(620 <= N && N <= 780 ? "Red" :
                590 <= N && N < 620 ? "Orange" :
                570 <= N && N < 590 ? "Yellow" :
                495 <= N && N < 570 ? "Green" :
                450 <= N && N < 495 ? "Blue" :
                425 <= N && N < 450 ? "Indigo" : "Violet");
    }
}
