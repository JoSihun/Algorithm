package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Main_G4_17140_이차원배열과연산 {
    private static int r, c, k;
    private static int answer;

    private static int maxRow;
    private static int maxCol;
    private static int[][] arr;


    public static class Number implements Comparable<Number> {
        int num;
        int cnt;

        public Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number o) {
            if (this.cnt == o.cnt)
                return this.num - o.num;
            return this.cnt - o.cnt;
        }
    }

    public static void operationR() {
        for (int i = 0; i < maxRow; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < maxCol; j++) {
                if (arr[i][j] == 0) continue;
                int num = arr[i][j];
                int cnt = map.getOrDefault(num, 0);
                map.put(num, cnt + 1);
                arr[i][j] = 0;
            }

            PriorityQueue<Number> pq = new PriorityQueue<>();
            map.forEach((key, value) -> pq.offer(new Number(key, value)));
            int size = Math.min(100, pq.size() * 2);
            maxCol = Math.max(size, maxCol);

            int jdx = 0;
            while (!pq.isEmpty() && jdx < 100) {
                arr[i][jdx++] = pq.peek().num;
                arr[i][jdx++] = pq.poll().cnt;
            }
        }
    }

    public static void operationC() {
        for (int j = 0; j < maxCol; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < maxRow; i++) {
                if (arr[i][j] == 0) continue;
                int num = arr[i][j];
                int cnt = map.getOrDefault(num, 0);
                map.put(num, cnt + 1);
                arr[i][j] = 0;
            }

            PriorityQueue<Number> pq = new PriorityQueue<>();
            map.forEach((key, value) -> pq.offer(new Number(key, value)));
            int size = Math.min(100, pq.size() * 2);
            maxRow = Math.max(size, maxRow);

            int idx = 0;
            while (!pq.isEmpty() && idx < 100) {
                arr[idx++][j] = pq.peek().num;
                arr[idx++][j] = pq.poll().cnt;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        arr = new int[100][100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        maxRow = 3; maxCol = 3;
        while (arr[r][c] != k && answer <= 100) {
            answer++;
            if (maxRow >= maxCol)
                operationR();
            else
                operationC();
        }

        if (answer > 100) answer = -1;
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
