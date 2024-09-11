package baekjoon.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G1_02357_최솟값과최댓값 {
    public static int N, M;
    public static int[] minTree;
    public static int[] maxTree;
    public static int[] numbers;

    public static int initMinTree(int start, int end, int node) {
        if (start == end) return minTree[node] = numbers[start];
        int mid = (start + end) / 2;
        int left = initMinTree(start, mid, node * 2);
        int right = initMinTree(mid + 1, end, node * 2 + 1);
        return minTree[node] = Math.min(left, right);
    }

    public static int initMaxTree(int start, int end, int node) {
        if (start == end) return maxTree[node] = numbers[start];
        int mid = (start + end) / 2;
        int left = initMaxTree(start, mid, node * 2);
        int right = initMaxTree(mid + 1, end, node * 2 + 1);
        return maxTree[node] = Math.max(left, right);
    }

    public static int minQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Integer.MAX_VALUE;
        if (left <= start && end <= right) return minTree[node];

        int mid = (start + end) / 2;
        int leftIndex = minQuery(start, mid, node * 2, left, right);
        int rightIndex = minQuery(mid + 1, end, node * 2 + 1, left, right);
        return Math.min(leftIndex, rightIndex);
    }

    public static int maxQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Integer.MIN_VALUE;
        if (left <= start && end <= right) return maxTree[node];

        int mid = (start + end) / 2;
        int leftIndex = maxQuery(start, mid, node * 2, left, right);
        int rightIndex = maxQuery(mid + 1, end, node * 2 + 1, left, right);
        return Math.max(leftIndex, rightIndex);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(br.readLine());

        minTree = new int[N * 4];
        maxTree = new int[N * 4];
        initMinTree(0, N - 1, 1);
        initMaxTree(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int min = minQuery(0, N - 1, 1, a, b);
            int max = maxQuery(0, N - 1, 1, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
