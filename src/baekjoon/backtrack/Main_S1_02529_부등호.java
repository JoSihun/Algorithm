package baekjoon.backtrack;

import java.io.*;
import java.util.*;

public class Main_S1_02529_부등호 {
    public static int K;
    public static char[] op;
    public static boolean[] visited;
    public static List<String> answers;

    public static void backtrack(String nums, int depth) {
        if (depth == K + 1) {
            if (isValid(nums))
                answers.add(nums);
            return;
        }

        for (int num = 0; num <= 9; num++) {
            if (visited[num]) continue;
            visited[num] = true;
            backtrack(nums + num, depth + 1);
            visited[num] = false;
        }
    }

    public static boolean isValid(String nums) {
        for (int i = 0; i < K; i++) {
            if (op[i] == '<' && nums.charAt(i) >= nums.charAt(i + 1))
                return false;
            if (op[i] == '>' && nums.charAt(i) <= nums.charAt(i + 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        op = new char[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            op[i] = st.nextToken().charAt(0);

        visited = new boolean[10];
        answers = new ArrayList<>();
        backtrack("", 0);

        Collections.sort(answers);
        StringBuilder sb = new StringBuilder();
        sb.append(answers.get(answers.size() - 1)).append("\n");
        sb.append(answers.get(0)).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
