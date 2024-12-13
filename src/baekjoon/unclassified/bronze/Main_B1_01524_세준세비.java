package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1524
public class Main_B1_01524_세준세비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Integer> queue1 = new ArrayDeque<>();
            Queue<Integer> queue2 = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                queue1.offer(Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                queue2.offer(Integer.parseInt(st.nextToken()));

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                int sejun = queue1.peek();
                int sebi = queue2.peek();

                if (sejun < sebi) queue1.poll();
                else queue2.poll();
            }

            sb.append(!queue1.isEmpty() ? "S" : !queue2.isEmpty() ? "B" : "C").append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
