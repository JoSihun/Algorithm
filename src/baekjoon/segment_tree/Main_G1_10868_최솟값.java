package baekjoon.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G1_10868_최솟값 {
    public static int N, M;
    public static int[] tree;
    public static int[] numbers;

    public static int init(int start, int end, int node) {
        if (start == end) return tree[node] = numbers[start];
        int mid = (start + end) / 2;
        int left = init(start, mid, node * 2);
        int right = init(mid + 1, end, node * 2 + 1);
        return tree[node] = Math.min(left, right);
    }

    public static int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Integer.MAX_VALUE;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        int leftIndex = query(start, mid, node * 2, left, right);
        int rightIndex = query(mid + 1, end, node * 2 + 1, left, right);
        return Math.min(leftIndex, rightIndex);
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

        tree = new int[N * 4];
        init(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(query(0, N - 1, 1, a, b)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
