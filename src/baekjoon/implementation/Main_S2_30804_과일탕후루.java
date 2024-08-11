package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Main_S2_30804_과일탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] fruits = new int[N];
        for (int i = 0; i < N; i++)
            fruits[i] = Integer.parseInt(st.nextToken());

        int answer = findMaxFruitCount(N, fruits);
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findMaxFruitCount(int N, int[] fruits) {
        int left = 0, answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < N; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
