package baekjoon.segment_tree;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution2 {
    private static int[] A;
    private static int[] temp;
    private static long answer = 0;

    public static void mergeSort(int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);
        merge(start, mid, end);
    }

    public static void merge(int start, int mid, int end) {
        int left = start;
        int index = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
                answer += (mid + 1 - left);
            }
        }

        while (left <= mid)
            temp[index++] = A[left++];
        while (right <= end)
            temp[index++] = A[right++];

        for (int i = start; i <= end; i++)
            A[i] = temp[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        A = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        mergeSort(0, N - 1);
        System.out.println(answer);
    }
}

public class Main_P5_01517_버블소트 {
    public static int N;
    public static int[] A;
    public static int[] tree;
    public static int[] sortedA;

    public static int init(int start, int end, int node) {
        if (start == end) return tree[node] = 0;
        int mid = (start + end) / 2;
        int left = init(start, mid, node * 2);
        int right = init(mid + 1, end, node * 2 + 1);
        return tree[node] = left + right;
    }

    public static int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) +
                query(mid + 1, end, node * 2 + 1, left, right);
    }

    public static int update(int start, int end, int node, int index, int value) {
        if (index < start || index > end) return tree[node];
        if (start == end) return tree[node] += value;

        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node * 2, index, value) +
                update(mid + 1, end, node * 2 + 1, index, value);
    }

    public static void compress() {
        sortedA = Arrays.copyOf(A, N);
        Arrays.sort(sortedA);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int value : sortedA)
            if (!map.containsKey(value))
                map.put(value, rank++);

        for (int i = 0; i < N; i++)
            A[i] = map.get(A[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        compress();
        tree = new int[N * 4];

        long answer = 0;
        for (int i = 0; i < N; i++) {
            // A[i]보다 큰 값들의 개수 == A[i] + 1부터 N - 1까지의 합
            answer += query(0, N - 1, 1, A[i] + 1, N - 1);
            // A[i] 값의 등장 횟수를 1 증가
            update(0, N - 1, 1, A[i], 1);
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
