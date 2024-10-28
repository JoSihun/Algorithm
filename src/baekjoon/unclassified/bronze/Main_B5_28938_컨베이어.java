package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_28938_컨베이어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) answer += Integer.parseInt(st.nextToken());
        System.out.println(answer == 0 ? "Stay" : answer < 0 ? "Left" : "Right");
    }
}
