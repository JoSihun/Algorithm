package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_09527_1의개수세기 {
    /*
        첫번째 비트 0001(1) 반복 주기 2
        두번째 비트 0010(2) 반복 주기 4
        세번째 비트 0100(4) 반복 주기 8
        네번째 비트 1000(8) 반복 주기 16
     */
    private static long prefixSum(long N) {
        if (N == 0) return 0;

        long count = 0;
        for (int bit = 0; (1L << bit) <= N; bit++) {
            // 현재 비트 크기
            long curBitValue = 1L << bit;           // 2^bit
            long nextBitValue = 1L << (bit + 1);    // 2^(bit + 1)

            // 현재 비트에서 1의 개수 계산
            long repeat = N / nextBitValue;
            count += curBitValue * repeat;

            // 남은 숫자에서 현재 비트의 1 개수 계산
            long remainder = N % nextBitValue;
            if (remainder >= curBitValue)
                count += remainder - curBitValue + 1;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        System.out.println(prefixSum(B) - prefixSum(A - 1));
    }
}
