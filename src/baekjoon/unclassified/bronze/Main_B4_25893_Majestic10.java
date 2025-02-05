package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_25893_Majestic10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int count = 0;
            String[] stats = br.readLine().split(" ");
            for (String stat : stats)
                if (Integer.parseInt(stat) >= 10)
                    count++;

            sb.append(String.join(" ", stats)).append("\n");
            sb.append(count == 0 ? "zilch" : count == 1 ? "double" :
                    count == 2 ? "double-double" : "triple-double").append("\n\n");
        }
        System.out.println(sb.toString().trim());
    }
}
