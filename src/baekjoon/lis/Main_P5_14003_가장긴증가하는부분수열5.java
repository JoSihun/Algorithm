package baekjoon.lis;

import java.io.*;
import java.util.*;

public class Main_P5_14003_가장긴증가하는부분수열5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] trace = new int[N];
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int idx = Collections.binarySearch(lis, A[i]);
            if (idx < 0) idx = Math.abs(idx + 1);

            if (idx < lis.size()) lis.set(idx, A[i]);
            else lis.add(A[i]);
            trace[i] = idx;
        }

        int size = lis.size();
        int[] answer = new int[size];
        for (int i = N - 1; i >= 0; i--) {
            if (trace[i] == size - 1) {
                answer[size - 1] = A[i];
                size--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()).append("\n");

        for (int a : answer) sb.append(a).append(" ");
        bw.write(sb.toString());
        bw.flush();
    }
}
