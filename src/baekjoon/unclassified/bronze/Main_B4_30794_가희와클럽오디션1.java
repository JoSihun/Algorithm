package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_30794_가희와클럽오디션1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lv = Integer.parseInt(st.nextToken());
        String eval = st.nextToken();

        int answer = 0;
        if (eval.equals("miss")) answer += 0;
        else if (eval.equals("bad")) answer += 200 * lv;
        else if (eval.equals("cool")) answer += 400 * lv;
        else if (eval.equals("great")) answer += 600 * lv;
        else if (eval.equals("perfect")) answer += lv * 1000;
        System.out.println(answer);
    }
}
