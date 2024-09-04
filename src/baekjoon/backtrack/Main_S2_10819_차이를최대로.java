package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S2_10819_차이를최대로 {
    public static int N;
    public static int[] A;
    public static int answer;
    public static int[] selected;
    public static boolean[] visited;

    // 중복 불가, 순서 고려 (순열)
    public static void backtrack(int depth) {
        if (depth == N) {
            answer = Math.max(answer, calculate());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                selected[depth] = A[i];
                visited[i] = true;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public static int calculate() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++)
            sum += Math.abs(selected[i] - selected[i + 1]);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        selected = new int[N];
        backtrack(0);

        bw.write(answer + "\n");
        bw.flush();
    }
}
