package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

public class Main_B1_20218_FigureSkating {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> predicted = new HashMap<>();
        for (int rank = 0; rank < N; rank++)
            predicted.put(br.readLine(), rank);

        Map<String, Integer> actualResult = new HashMap<>();
        for (int rank = 0; rank < N; rank++)
            actualResult.put(br.readLine(), rank);

        int maxDiff = 0;
        String answer = null;
        for (String name : actualResult.keySet()) {
            int diff = predicted.get(name) - actualResult.get(name);
            if (maxDiff < diff || (diff == maxDiff &&
                    (answer == null || actualResult.get(name) < actualResult.get(answer)))) {
                answer = name;
                maxDiff = diff;
            }
        }
        System.out.println(maxDiff == 0 ? "suspicious" : answer);
    }
}
