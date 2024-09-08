package baekjoon.backtrack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_17406_배열돌리기4 {
    public static int N, M, K;
    public static int answer;
    public static int[][] op;
    public static int[][] map;
    public static int[] selected;
    public static boolean[] visited;

    public static void backtrack(int depth) {
        if (depth == K) {
            int[][] copyMap = deepCopy();
            for (int i = 0; i < K; i++)
                rotate(selected[i], copyMap);
            answer = Math.min(answer, calculate(copyMap));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[depth] = i;
            backtrack(depth + 1);
            visited[i] = false;
        }
    }

    public static int[][] deepCopy() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++)
            copyMap[i] = Arrays.copyOf(map[i], M);
        return copyMap;
    }

    public static void rotate(int k, int[][] copyMap) {
        // 1-based to 0-based
        int R = op[k][0] - 1, C = op[k][1] - 1, S = op[k][2];

        for (int s = 1; s <= S; s++) {
            int temp = copyMap[R - s][C - s];
            for (int r = R - s; r < R + s; r++)     // Left
                copyMap[r][C - s] = copyMap[r + 1][C - s];
            for (int c = C - s; c < C + s; c++)     // Bottom
                copyMap[R + s][c] = copyMap[R + s][c + 1];
            for (int r = R + s; r > R - s; r--)     // Right
                copyMap[r][C + s] = copyMap[r - 1][C + s];
            for (int c = C + s; c > C - s; c--)     // Top
                copyMap[R - s][c] = copyMap[R - s][c - 1];
            copyMap[R - s][C - s + 1] = temp;
        }
    }

    public static int calculate(int[][] copyMap) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++)
                sum += copyMap[i][j];
            result = Math.min(result, sum);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        op = new int[K][3];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            op[k][0] = Integer.parseInt(st.nextToken());    // r
            op[k][1] = Integer.parseInt(st.nextToken());    // c
            op[k][2] = Integer.parseInt(st.nextToken());    // s
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[K];
        selected = new int[K];
        backtrack(0);

        bw.write(answer + "\n");
        bw.flush();
    }
}
