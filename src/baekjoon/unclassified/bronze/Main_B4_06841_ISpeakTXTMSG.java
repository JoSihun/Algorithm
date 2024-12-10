package baekjoon.unclassified.bronze;

import java.io.*;
import java.util.*;

public class Main_B4_06841_ISpeakTXTMSG {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("CU", "see you");
        map.put(":-)", "I’m happy");
        map.put(":-(", "I’m unhappy");
        map.put(";-)", "wink");
        map.put(":-P", "stick out my tongue");
        map.put("(~.~)", "sleepy");
        map.put("TA", "totally awesome");
        map.put("CCC", "Canadian Computing Competition");
        map.put("CUZ", "because");
        map.put("TY", "thank-you");
        map.put("YW", "you’re welcome");
        map.put("TTYL", "talk to you later");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            sb.append(map.getOrDefault(input, input)).append("\n");
            if (input.equals("TTYL")) break;
        }
        System.out.println(sb.toString().trim());
    }
}
