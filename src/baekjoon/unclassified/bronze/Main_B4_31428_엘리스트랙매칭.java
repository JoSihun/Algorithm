package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Main_B4_31428_엘리스트랙매칭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tracks = br.readLine().split(" ");
        String hellobit = br.readLine();
        System.out.println(Arrays.stream(tracks)
                .filter(track -> track.equals(hellobit)).count());
    }
}
