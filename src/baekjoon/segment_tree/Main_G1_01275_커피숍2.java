package baekjoon.segment_tree;

import java.io.*;
import java.util.*;

public class Main_G1_01275_커피숍2 {
    public static int N, Q;
    public static long[] tree;
    public static long[] numbers;

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = numbers[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) +
                init(mid + 1, end, node * 2 + 1);
    }

    public static long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) +
                query(mid + 1, end, node * 2 + 1, left, right);
    }

    public static long update(int start, int end, int node, int index, long value) {
        if (index < start || index > end) return tree[node];
        if (start == end) return tree[node] = value;

        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node * 2, index, value) +
                update(mid + 1, end, node * 2 + 1, index, value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        numbers = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Long.parseLong(st.nextToken());

        tree = new long[N * 4];
        init(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());

            if (x > y) {
                int temp = x;
                x = y; y = temp;
            }

            sb.append(query(0, N - 1, 1, x, y)).append("\n");
            update(0, N - 1, 1, a, b);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
