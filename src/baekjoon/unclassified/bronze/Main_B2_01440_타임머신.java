package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_01440_타임머신 {
    private static int permutation(int depth, int[] numbers, int[] selected, boolean[] visited) {
        if (depth == 3) return isValid(selected) ? 1 : 0;

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[depth] = numbers[i];
            count += permutation(depth + 1, numbers, selected, visited);
            visited[i] = false;
        }
        return count;
    }

    private static boolean isValid(int[] selected) {
        int hour = selected[0];
        int minute = selected[1];
        int second = selected[2];
        return 1 <= hour && hour <= 12 && 0 <= minute && minute <= 59 && 0 <= second && second <= 59;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(":");

        int[] times = new int[3];
        for (int i = 0; i < 3; i++)
            times[i] = Integer.parseInt(input[i]);
        System.out.println(permutation(0, times, new int[3], new boolean[3]));
    }
}
