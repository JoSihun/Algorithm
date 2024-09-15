package baekjoon.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G1_11505_구간곱구하기 {
    public static int N, M, K;
    public static int MOD = 1000000007;
    public static long[] tree;
    public static long[] numbers;

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = numbers[start];
        int mid = (start + end) / 2;
        long left = init(start, mid, node * 2);
        long right = init(mid + 1, end, node * 2 + 1);
        return tree[node] = left * right % MOD;
    }

    public static long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 1;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        long leftIndex = query(start, mid, node * 2, left, right);
        long rightIndex = query(mid + 1, end, node * 2 + 1, left, right);
        return leftIndex * rightIndex % MOD;
    }

    public static long update(int start, int end, int node, int index, int value) {
        if (index < start || index > end) return tree[node];
        if (start == end) return tree[node] = value;

        int mid = (start + end) / 2;
        long left = update(start, mid, node * 2, index, value);
        long right = update(mid + 1, end, node * 2 + 1, index, value);
        return tree[node] = left * right % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new long[N];
        for (int i = 0; i < N; i++)
            numbers[i] = Long.parseLong(br.readLine());

        tree = new long[N * 4];
        init(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(0, N - 1, 1, b - 1, c);
            } else if (a == 2) {
                sb.append(query(0, N - 1, 1, b - 1, c - 1)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
