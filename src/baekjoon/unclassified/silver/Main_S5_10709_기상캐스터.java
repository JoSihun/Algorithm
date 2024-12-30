package baekjoon.unclassified.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_10709_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++)
            Arrays.fill(map[i], -1);

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            int count = -1;
            for (int j = 0; j < W; j++) {
                if (line.charAt(j) == 'c') {
                    map[i][j] = count = 0;
                } else if (count != -1) {
                    map[i][j] = ++count;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                sb.append(map[i][j]).append(j == W - 1 ? "\n" : " ");
        System.out.println(sb.toString().trim());
    }
}
