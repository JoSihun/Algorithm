package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_32498_CallforProblems {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while (N-- > 0) {
            if (Integer.parseInt(br.readLine()) % 2 == 1)
                count++;
        }
        System.out.println(count);
    }
}
