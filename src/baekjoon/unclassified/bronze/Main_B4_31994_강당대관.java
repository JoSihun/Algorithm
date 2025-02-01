package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B4_31994_강당대관 {
    public static class Seminar implements Comparable<Seminar> {
        public String name;
        public int applicants;

        public Seminar(String name, int applicants) {
            this.name = name;
            this.applicants = applicants;
        }

        @Override
        public int compareTo(Seminar o) {
            return o.applicants - this.applicants;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Seminar> pq = new PriorityQueue<Seminar>();
        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Seminar(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        System.out.println(pq.poll().name);
    }
}
