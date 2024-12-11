package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

public class Main_B4_09699_RICESACK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int result = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).max().getAsInt();
            sb.append("Case #").append(tc).append(": ").append(result).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
