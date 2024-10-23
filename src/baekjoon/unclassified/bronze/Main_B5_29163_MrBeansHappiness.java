package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B5_29163_MrBeansHappiness {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) answer += Integer.parseInt(st.nextToken()) % 2 == 0 ? 1 : -1;
        System.out.println(answer > 0 ? "Happy" : "Sad");
    }
}
