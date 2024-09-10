package baekjoon.segment_tree;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_P5_06549_히스토그램에서가장큰직사각형 {
    public static int N;
    public static int[] heights;

    private static long calculate() {
        Stack<Integer> stack = new Stack<>();

        long maxArea = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? N : N - stack.peek() - 1;
            maxArea = Math.max(maxArea, (long) height * width);
        }
        return maxArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            heights = new int[N];
            for (int i = 0; i < N; i++)
                heights[i] = Integer.parseInt(st.nextToken());

            sb.append(calculate()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
