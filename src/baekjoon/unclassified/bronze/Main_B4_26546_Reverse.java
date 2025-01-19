package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_26546_Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(input.substring(0, i)).append(input.substring(j)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
