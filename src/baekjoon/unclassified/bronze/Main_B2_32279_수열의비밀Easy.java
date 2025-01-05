package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_32279_수열의비밀Easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] a = new int[N + 1];
        a[1] = Integer.parseInt(br.readLine());

        int answer = a[1];
        for (int i = 2; i < N + 1; i++) {
            a[i] = i % 2 == 0 ? p * a[i / 2] + q : r * a[i / 2] + s;
            answer += a[i];
        }
        System.out.println(answer);
    }
}
