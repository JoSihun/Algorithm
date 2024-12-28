package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

public class Main_B2_23275_KnotKnowledge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            set.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++)
            set.remove(Integer.parseInt(st.nextToken()));

        System.out.println(set.iterator().next());
    }
}
