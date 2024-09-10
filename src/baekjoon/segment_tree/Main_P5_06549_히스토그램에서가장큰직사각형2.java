package baekjoon.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main_P5_06549_히스토그램에서가장큰직사각형2 {
    public static int N;
    public static int[] tree;
    public static int[] heights;

    public static int init(int start, int end, int node) {
        if (start == end) return tree[node] = start;

        int mid = (start + end) / 2;
        int left = init(start, mid, node * 2);
        int right = init(mid + 1, end, node * 2 + 1);
        return tree[node] = heights[left] <= heights[right] ? left : right;
    }

    public static int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return -1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        int leftIdx = query(start, mid, node * 2, left, right);
        int rightIdx = query(mid + 1, end, node * 2 + 1, left, right);

        if (leftIdx == -1) return rightIdx;
        if (rightIdx == -1) return leftIdx;
        return heights[leftIdx] <= heights[rightIdx] ? leftIdx : rightIdx;
    }

    public static long calculate(int left, int right) {
        if (left > right) return 0;
        int minIdx = query(0, N - 1, 1, left, right);
        long area = (long) (right - left + 1) * heights[minIdx];

        long leftArea = calculate(left, minIdx - 1);
        long rightArea = calculate(minIdx + 1, right);
        return Math.max(area, Math.max(leftArea, rightArea));
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

            tree = new int[N * 4];
            init(0, N - 1, 1);
            sb.append(calculate(0, N - 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
