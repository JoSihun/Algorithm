package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_29807_학번을찾아줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[5];
        for (int i = 0; i < T; i++)
            scores[i] = Integer.parseInt(st.nextToken());

        int answer = scores[4] * 707;
        answer += Math.abs(scores[0] - scores[2]) * (scores[0] > scores[2] ? 508 : 108);
        answer += Math.abs(scores[1] - scores[3]) * (scores[1] > scores[3] ? 212 : 305);
        System.out.println(answer * 4763);
    }
}
