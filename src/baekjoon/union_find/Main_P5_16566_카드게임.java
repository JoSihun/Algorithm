package baekjoon.union_find;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_P5_16566_카드게임 {
    public static int N, M, K;
    public static int[] cards;
    public static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        parent[rootX] = rootY;
    }

    public static int binarySearch(int x) {
        int left = 0, right = M - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x < cards[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return cards[left];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++)
            parent[i] = i;

        cards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = find(binarySearch(a));
            sb.append(b).append("\n");
            union(b, b + 1);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
