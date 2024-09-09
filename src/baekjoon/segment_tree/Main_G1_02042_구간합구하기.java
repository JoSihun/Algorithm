package baekjoon.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G1_02042_구간합구하기 {
    public static int N, M, K;
    public static long[] tree;
    public static long[] numbers;

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = numbers[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) return;
        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, diff);
            update(mid + 1, end, node * 2 + 1, index, diff);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new long[4 * N];
        numbers = new long[N + 1];
        for (int i = 1; i < N + 1; i++)
            numbers[i] = Long.parseLong(br.readLine());

        init(1, N, 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - numbers[b];
                numbers[b] = c;
                update(1, N, 1, b, diff);
            } else if (a == 2) {
                sb.append(sum(1, N, 1, b, (int) c)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
