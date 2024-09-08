package baekjoon.backtrack;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_G5_01038_감소하는수 {
    public static int N;
    public static List<Long> answers;

    public static void backtrack(int limit, long num) {
        answers.add(num);
        for (int i = 0; i < limit; i++)
            backtrack(i, num * 10 + i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        answers = new ArrayList<>();
        for (int i = 0; i <= 9; i++)
            backtrack(i, i);

        Collections.sort(answers);
        long answer = answers.size() > N ? answers.get(N) : -1;
        bw.write(answer + "\n");
        bw.flush();
    }
}
