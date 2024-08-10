package baekjoon.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G5_20055_컨베이어벨트위의로봇 {
    private static int N, K;
    private static int answer;
    private static int[] A;
    private static int[] robot;

    public static void rotate() {
        int temp = A[2 * N];
        for (int i = 2 * N; i > 1; i--)
            A[i] = A[i - 1];
        A[1] = temp;

        for (int i = N; i > 1; i--)
            robot[i] = robot[i - 1];
        robot[1] = 0;
        robot[N] = 0;
    }
    
    public static void move() {
        for (int i = N; i > 1; i--) {
            if (robot[i - 1] == 1 && robot[i] == 0 && A[i] > 0) {
                robot[i] = 1;
                robot[i - 1] = 0;
                A[i]--;
            }
        }
        robot[N] = 0;
    }

    public static void add() {
        if (robot[1] == 0 && A[1] > 0) {
            robot[1] = 1;
            A[1]--;
        }
    }

    public static boolean isValid() {
        int cnt = 0;
        for (int i = 1; i < 2 * N + 1; i++)
            if (A[i] == 0) cnt++;
        return cnt < K;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[2 * N + 1];
        robot = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 2 * N + 1; i++)
            A[i] = Integer.parseInt(st.nextToken());

        answer = 0;
        while (isValid()) {
            answer++;
            rotate();
            move();
            add();
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
