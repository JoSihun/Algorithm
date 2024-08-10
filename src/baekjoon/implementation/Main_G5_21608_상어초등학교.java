package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Main_G5_21608_상어초등학교 {
    private static int N, answer;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static Map<Integer, Set<Integer>> preference;

    public static class Student implements Comparable<Student> {
        int r, c;
        int cntLike;
        int cntEmpty;

        public Student(int r, int c, int cntLike, int cntEmpty) {
            this.r = r;
            this.c = c;
            this.cntLike = cntLike;
            this.cntEmpty = cntEmpty;
        }

        @Override
        public int compareTo(Student o) {
            if (this.cntLike != o.cntLike) return o.cntLike - this.cntLike;
            if (this.cntEmpty != o.cntEmpty) return o.cntEmpty - this.cntEmpty;
            if (this.r != o.r) return this.r - o.r;
            return this.c - o.c;
        }
    }

    public static void findSeat(int student) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] != 0) continue;

                int cntLike = 0;
                int cntEmpty = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                    if (map[nr][nc] == 0) cntEmpty++;
                    else if (preference.get(student).contains(map[nr][nc])) cntLike++;
                }
                pq.add(new Student(i, j, cntLike, cntEmpty));
            }
        }
        Student s = pq.poll();
        map[s.r][s.c] = student;
    }

    public static void calculateScore() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int cntLike = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                    if (preference.get(map[i][j]).contains(map[nr][nc])) cntLike++;
                }
                if (cntLike == 0) continue;
                answer += Math.pow(10, cntLike - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        preference = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            int s4 = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();
            set.add(s1); set.add(s2);
            set.add(s3); set.add(s4);
            preference.put(s, set);
            findSeat(s);
        }

        calculateScore();
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
