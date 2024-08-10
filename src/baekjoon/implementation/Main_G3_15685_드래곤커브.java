package baekjoon.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G3_15685_드래곤커브 {
    private static int N, answer;
    private static boolean[][] map;

    public static List<Integer> calculateDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }
        return directions;
    }

    public static void drawingCurves(int x, int y, List<Integer> directions) {
        map[x][y] = true;
        for (int direction : directions) {
            if (direction == 0) map[++x][y] = true;
            else if (direction == 1) map[x][--y] = true;
            else if (direction == 2) map[--x][y] = true;
            else if (direction == 3) map[x][++y] = true;
        }
    }

    public static int countSquare() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new boolean[101][101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            drawingCurves(x, y, calculateDirections(d, g));
        }

        answer = countSquare();
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
