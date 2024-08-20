package baekjoon.lis;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G2_12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int idx = Collections.binarySearch(lis, A[i]);
            if (idx < 0) idx = Math.abs(idx + 1);

            if (idx < lis.size()) lis.set(idx, A[i]);
            else lis.add(A[i]);
        }

        bw.write(String.valueOf(lis.size()));
        bw.flush();
    }
}
