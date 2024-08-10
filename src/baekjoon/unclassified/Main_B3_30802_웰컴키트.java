package baekjoon.unclassified;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B3_30802_웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++)
            sizes[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int size : sizes)
            answer += size / T + (size % T > 0 ? 1 : 0);

        bw.write(answer + "\n");
        bw.write(N / P + " " + N % P + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
