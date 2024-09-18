package baekjoon.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main_P5_02243_사탕상자 {
    public static int N;
    public static int size;
    public static int[] tree;

    public static int query(int start, int end, int node, int rank) {
        if (start == end) return start;

        int mid = (start + end) / 2;
        if (tree[node * 2] >= rank) return query(start, mid, node * 2, rank);
        return query(mid + 1, end, node * 2 + 1, rank - tree[node * 2]);
    }

    public static void update(int start, int end, int node, int index, int value) {
        if (index < start || index > end) return;
        tree[node] += value;

        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, value);
            update(mid + 1, end, node * 2 + 1, index, value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        size = 1000000;
        tree = new int[size * 4];
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());         // A

            if (command == 1) {
                int rank = Integer.parseInt(st.nextToken());        // B
                int flavor = query(1, size, 1, rank);
                update(1, size, 1, flavor, -1);
                sb.append(flavor).append("\n");
            } else if (command == 2) {
                int flavor = Integer.parseInt(st.nextToken());      // B
                int count = Integer.parseInt(st.nextToken());       // C
                update(1, size, 1, flavor, count);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
