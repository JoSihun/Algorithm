package baekjoon.segment_tree;

import java.io.*;

public class Main_P5_01725_히스토그램 {
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
        int leftIndex = query(start, mid, node * 2, left, right);
        int rightIndex = query(mid + 1, end, node * 2 + 1, left, right);

        if (leftIndex == -1) return rightIndex;
        if (rightIndex == -1) return leftIndex;
        return heights[leftIndex] <= heights[rightIndex] ? leftIndex : rightIndex;
    }

    public static long calculate(int left, int right) {
        if (left > right) return 0;
        int minIndex = query(0, N - 1, 1, left, right);

        long area = (long) (right - left + 1) * heights[minIndex];
        long leftArea = calculate(left, minIndex - 1);
        long rightArea = calculate(minIndex + 1, right);
        return Math.max(area, Math.max(leftArea, rightArea));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        heights = new int[N];
        for (int i = 0; i < N; i++)
            heights[i] = Integer.parseInt(br.readLine());

        tree = new int[N * 4];
        init(0, N - 1, 1);
        System.out.println(calculate(0, N - 1));
    }
}
