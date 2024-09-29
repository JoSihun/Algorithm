package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_B5_27889_특별한학교이름 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();
        map.put("NLCS", "North London Collegiate School");
        map.put("BHA", "Branksome Hall Asia");
        map.put("KIS", "Korea International School");
        map.put("SJA", "St. Johnsbury Academy");
        System.out.println(map.get(br.readLine()));
    }
}
