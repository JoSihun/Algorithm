package baekjoon.unclassified;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G2_07453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[N * N];
        int[] CD = new int[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[i * N + j] = A[i] + B[j];
                CD[i * N + j] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        int left = 0, right = N * N - 1;
        while (left < N * N && right >= 0) {
            int sum = AB[left] + CD[right];
            if (sum == 0) {
                long abCount = 1, cdCount = 1;

                while (left < N * N - 1 && AB[left] == AB[left + 1]) {
                    abCount++;
                    left++;
                }
                while (right > 0 && CD[right] == CD[right - 1]) {
                    cdCount++;
                    right--;
                }

                answer += abCount * cdCount;
                left++; right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
