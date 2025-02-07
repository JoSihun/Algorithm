package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/25932
public class Main_B4_25932_FindTheTwins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            Set<Integer> set = new HashSet<>();
            String[] jerseys = br.readLine().split(" ");
            for (String jersey : jerseys)
                set.add(Integer.parseInt(jersey));

            boolean hasMack = set.contains(18);
            boolean hasZack = set.contains(17);
            sb.append(String.join(" ", jerseys)).append("\n");
            sb.append(hasMack && hasZack ? "both" :
                    hasMack ? "mack" : hasZack ? "zack" : "none").append("\n\n");
        }
        System.out.println(sb.toString().trim());
    }
}
