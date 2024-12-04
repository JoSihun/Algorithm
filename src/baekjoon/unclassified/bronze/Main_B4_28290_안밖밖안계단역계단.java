package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_B4_28290_안밖밖안계단역계단 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();
        map.put("fdsajkl;", "in-out");
        map.put("jkl;fdsa", "in-out");
        map.put("asdf;lkj", "out-in");
        map.put(";lkjasdf", "out-in");
        map.put("asdfjkl;", "stairs");
        map.put(";lkjfdsa", "reverse");

        String input = br.readLine();
        System.out.println(map.getOrDefault(input, "molu"));
    }
}
