package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S1_14889_스타트와링크 {
    private static int N;
    private static int[][] S;
    private static int answer;

    public static void backtrack(int idx, int cnt, boolean[] selected) {
        if (cnt == N / 2) {
            int[] startTeam = new int[N / 2];
            int[] linkTeam = new int[N / 2];

            int startIdx = 0;
            int linkIdx = 0;
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    startTeam[startIdx++] = i;
                } else {
                    linkTeam[linkIdx++] = i;
                }
            }

            int startSum = 0;
            int linkSum = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    startSum += S[startTeam[i]][startTeam[j]];
                    linkSum += S[linkTeam[i]][linkTeam[j]];
                }
            }

            answer = Math.min(answer, Math.abs(startSum - linkSum));
            return;
        } else if (idx == N) {
            return;
        }

        selected[idx] = true;
        backtrack(idx + 1, cnt + 1, selected);
        selected[idx] = false;
        backtrack(idx + 1, cnt, selected);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        backtrack(0, 0, new boolean [N]);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
