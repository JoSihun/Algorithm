package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_32642_당구좀치자제발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long answer = 0; long curAnger = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int weather = Integer.parseInt(st.nextToken());
            curAnger = weather == 1 ? curAnger + 1 : curAnger - 1;
            answer += curAnger;
        }
        System.out.println(answer);
    }
}
