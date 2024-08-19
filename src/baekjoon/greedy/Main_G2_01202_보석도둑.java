package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G2_01202_보석도둑 {
    public static class Jewel implements Comparable<Jewel> {
        public int weight, price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            if (this.weight == o.weight)
                return o.price - this.price;
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            pq.offer(new Jewel(M, V));
        }

        int[] knapsack = new int[K];
        for (int i = 0; i < K; i++)
            knapsack[i] = Integer.parseInt(br.readLine());

        long answer = 0;
        Arrays.sort(knapsack);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int k = 0; k < K; k++) {
            while (!pq.isEmpty() && pq.peek().weight <= knapsack[k])
                maxHeap.offer(pq.poll().price);

            if (!maxHeap.isEmpty())
                answer += maxHeap.poll();
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
