package baekjoon.unclassified.gold;

import java.io.*;
import java.util.*;

public class Main_G3_02143_두배열의합 {

    private static long findAnswer(List<Long> subA, List<Long> subB, long T) {
        long answer = 0;
        int pointerA = 0;
        int pointerB = subB.size() - 1;
        while (pointerA < subA.size() && pointerB >= 0) {
            long sumA = subA.get(pointerA);
            long sumB = subB.get(pointerB);

            if (sumA + sumB == T) {
                long countA = 0, countB = 0;
                while (pointerA < subA.size() && subA.get(pointerA) == sumA) {
                    pointerA++;
                    countA++;
                }
                while (pointerB >= 0 && subB.get(pointerB) == sumB) {
                    pointerB--;
                    countB++;
                }
                answer += countA * countB;
            } else if (sumA + sumB < T) {
                pointerA++;
            } else if (sumA + sumB > T) {
                pointerB--;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long T = Long.parseLong(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                subA.add(sum);
            }
        }
        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                subB.add(sum);
            }
        }
        Collections.sort(subA);
        Collections.sort(subB);

        long answer = findAnswer(subA, subB, T);
        bw.write(String.valueOf(answer));
        bw.flush();
    }


}
