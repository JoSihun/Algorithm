package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_B4_28431_양말짝맞추기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            map.put(num, !map.getOrDefault(num, false));
        }

        for (int key : map.keySet()) {
            if (map.get(key)) {
                System.out.println(key);
                return;
            }
        }
    }
}
