package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_28295_체육은코딩과목입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dir = 0;
        for (int i = 0; i < 10; i++)
            dir += Integer.parseInt(br.readLine());

        char[] direction = {'N', 'E', 'S', 'W'};
        System.out.println(direction[dir % 4]);
    }
}
