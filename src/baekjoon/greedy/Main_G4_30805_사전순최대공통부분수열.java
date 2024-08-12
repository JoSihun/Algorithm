package baekjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G4_30805_사전순최대공통부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        int a = 0, b = 0;
        List<Integer> list = new ArrayList<>();
        while (a < N && b < M) {
            int max = -1, indexA = -1, indexB = -1;
            for (int i = a; i < N; i++) {
                for (int j = b; j < M; j++) {
                    if (A[i] == B[j] && A[i] > max) {
                        max = A[i];
                        indexA = i;
                        indexB = j;
                    }
                }
            }
            if (max == -1) break;
            list.add(max);
            a = indexA + 1;
            b = indexB + 1;
        }

        sb.append(list.size()).append('\n');
        for (int num : list)
            sb.append(num).append(' ');

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
