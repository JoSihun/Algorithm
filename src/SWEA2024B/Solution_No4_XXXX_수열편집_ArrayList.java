package SWEA2024B;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_No4_XXXX_수열편집_ArrayList {
    private static int N, M, L;
    private static int x, y, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                switch (command) {
                    case 'I':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        list.add(x, y);
                        break;
                    case 'D':
                        x = Integer.parseInt(st.nextToken());
                        list.remove(x);
                        break;
                    case 'A':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        list.set(x, y);
                        break;
                }
            }

            answer = list.size() > L ? list.get(L) : -1;
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
