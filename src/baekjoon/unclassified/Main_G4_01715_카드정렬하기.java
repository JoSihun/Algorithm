package baekjoon.unclassified;

import java.io.*;
import java.util.PriorityQueue;

public class Main_G4_01715_카드정렬하기 {
    private static int N;
    private static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++)
            pq.offer(Long.parseLong(br.readLine()));

        while (pq.size() > 1) {
            Long temp1 = pq.poll();
            Long temp2 = pq.poll();

            answer += temp1 + temp2;
            pq.add(temp1 + temp2);
        }

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
