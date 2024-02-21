package SWEA.PRO.LECTURE2024;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_No3_1230_암호문3_ArrayList {
    private static int N, M;
    private static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            ArrayList<Integer> list = new ArrayList<>();

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                char command = st.nextToken().charAt(0);
                switch (command) {
                    case 'I':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            list.add(x + j, Integer.parseInt(st.nextToken()));
                        }
                        break;
                    case 'D':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            list.remove(x);
                        }
                        break;
                    case 'A':
                        int y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            list.add(Integer.parseInt(st.nextToken()));
                        }
                        break;
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
