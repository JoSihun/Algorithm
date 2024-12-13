package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/13777
public class Main_B1_13777_HuntTheRabbit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            Queue<Integer> track = new ArrayDeque<>();
            int left = 1, right = 50;
            while (left <= right) {
                int mid = (left + right) / 2;
                track.add(mid);

                if (mid == N) break;
                if (mid < N) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            while (!track.isEmpty())
                sb.append(track.poll())
                        .append(!track.isEmpty() ? " " : "\n");
        }

        System.out.println(sb.toString().trim());
    }
}
