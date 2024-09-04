package baekjoon.backtrack;

import java.util.Arrays;

public class Main_XX_99999_기본코드 {
    public static int N, M;
    public static int[] numbers;
    public static int[] selected;
    public static boolean[] visited;

    // 1. 중복 허용, 순서 고려 (순열)
    public static void permutation1(int depth) {
        /* 같은 숫자 여러번 선택 가능, 순서가 다르면 중복이 아닌 것으로 처리
         * { 1, 1, 1 } 선택 가능 (중복 허용)
         * { 1, 1, 2 }, { 2, 1, 1 } 선택 가능 (순서 고려)
         */
        if (depth == M) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        for (int i = 0; i < N; i++) {
            selected[depth] = numbers[i];
            permutation1(depth + 1);
        }
    }

    // 2. 중복 불가, 순서 고려 (순열)
    public static void permutation2(int depth) {
        /* 같은 숫자 여러번 선택 불가능, 순서가 다르면 중복이 아닌 것으로 처리
         * { 1, 1, 1 } 선택 불가능 (중복 불가)
         * { 1, 2, 3 }, { 3, 2, 1 } 선택 가능 (순서 고려)
         * */
        if (depth == M) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[depth] = numbers[i];
            permutation2(depth + 1);
            visited[i] = false;
        }
    }

    // 3. 중복 허용, 순서 무관 (조합)
    public static void combination1(int start, int depth) {
        /* 같은 숫자 여러번 선택 가능, 순서가 다르면 중복으로 처리
         * { 1, 1, 1 } 선택 가능 (중복 허용)
         * { 1, 1, 2 }, { 2, 1, 1 } 선택 불가능 (순서 무관)
         * */
        if (depth == M) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        for (int i = start; i < N; i++) {
            selected[depth] = numbers[i];
            combination1(i, depth + 1);
        }
    }

    // 4. 중복 불가, 순서 무관 (조합)
    public static void combination2(int start, int depth) {
        /* 같은 숫자 여러번 선택 불가능, 순서가 다르면 중복으로 처리
         * { 1, 1, 1 } 선택 불가능 (중복 불가)
         * { 1, 2, 3 }, { 3, 2, 1 } 선택 불가능 (순서 무관)
         * */
        if (depth == M) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        for (int i = start; i < N; i++) {
            selected[depth] = numbers[i];
            combination2(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) {
        N = 5; M = 3;
        numbers = new int[]{ 1, 2, 3, 4, 5 };
        selected = new int[M];
        visited = new boolean[N];

        permutation1(0);            // 중복 허용, 순서 고려 (순열)
        permutation2(0);            // 중복 불가, 순서 고려 (순열)
        combination1(0, 0);     // 중복 허용, 순서 무관 (조합)
        combination2(0, 0);     // 중복 불가, 순서 무관 (조합)
    }
}
