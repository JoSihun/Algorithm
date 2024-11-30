package baekjoon.unclassified.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* https://www.acmicpc.net/problem/12850 */
public class Main_G1_12850_본대산책2 {
    static final int MOD = 1_000_000_007;
    static final int N = 8;

    /* 단위 행렬 생성 */
    static int[][] identityMatrix(int size) {
        int[][] identity = new int[size][size];
        for (int i = 0; i < size; i++)
            identity[i][i] = 1;
        return identity;
    }

    /* 행렬 곱셈 */
    static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += (long) a[i][k] * b[k][j];
                    sum %= MOD;
                }
                result[i][j] = (int) sum;
            }
        }
        return result;
    }

    /* 행렬 거듭제곱 (분할 정복) */
    static int[][] matrixExponentiation(int[][] base, long exp) {
        // 결과를 단위 행렬로 초기화
        int[][] result = identityMatrix(N);

        while (exp > 0) {
            if (exp % 2 == 1) result = multiplyMatrix(result, base);
            base = multiplyMatrix(base, base);
            exp /= 2;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long D = Long.parseLong(br.readLine());

        // 그래프를 인접 행렬로 표현
        int[][] graph = {
                {0, 1, 1, 0, 0, 0, 0, 0}, // 0
                {1, 0, 0, 1, 1, 0, 0, 0}, // 1
                {1, 0, 0, 0, 1, 0, 0, 0}, // 2
                {0, 1, 0, 0, 1, 1, 1, 0}, // 3
                {0, 1, 1, 1, 0, 0, 1, 0}, // 4
                {0, 0, 0, 1, 0, 0, 1, 1}, // 5
                {0, 0, 0, 1, 1, 1, 0, 1}, // 6
                {0, 0, 0, 0, 0, 1, 1, 0}  // 7: 정보대
        };

        // 행렬 거듭제곱 계산
        int[][] answer = matrixExponentiation(graph, D);

        // 정보대(7번)에서 다시 정보대(7번)로 가는 경우의 수 출력
        System.out.println(answer[7][7]);
    }
}
