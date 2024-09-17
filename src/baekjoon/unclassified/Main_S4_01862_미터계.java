package baekjoon.unclassified;

import java.io.*;

public class Main_S4_01862_미터계 {
    public static int solution(int N) {
        int result = 0, place = 1;
        while (N > 0) {
            int num = N % 10;
            if (num > 4) num--;

            result += num * place;
            place = place * 9;
            N /= 10;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(br.readLine())));
    }
}
