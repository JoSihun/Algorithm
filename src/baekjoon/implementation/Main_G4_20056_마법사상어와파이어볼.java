package baekjoon.implementation;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_20056_마법사상어와파이어볼 {
    private static int N, M, K;
    private static int answer;

    private static int[][][] map;
    private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            queue.offer(new int[] { r, c, m, s, d });

        }

        // 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
        // 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
        while (K-- > 0) {
            map = new int[N][N][5];
            while (!queue.isEmpty()) {
                int r = queue.peek()[0];
                int c = queue.peek()[1];
                int m = queue.peek()[2];
                int s = queue.peek()[3];
                int d = queue.poll()[4];

                int nr = (r + (N + dr[d] * (s % N))) % N;
                int nc = (c + (N + dc[d] * (s % N))) % N;
                map[nr][nc][0] += 1;        // 개수
                map[nr][nc][1] += m;        // 질량 합
                map[nr][nc][2] += s;        // 속도 합
                map[nr][nc][3] += d;        // 마지막 파이어볼 방향
                map[nr][nc][4] += d % 2;    // 짝수이면 카운트 증가
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j][0] == 1) {
                        queue.offer(new int[] { i, j, map[i][j][1], map[i][j][2], map[i][j][3] });
                        continue;
                    }
                    if (map[i][j][1] / 5 == 0) continue;    // 질량이 0인 파이어볼은 소멸되어 없어진다.

                    int m = map[i][j][1] / 5;               // 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
                    int s = map[i][j][2] / map[i][j][0];    // 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
                    if (map[i][j][4] == 0 || map[i][j][4] == map[i][j][0]) {
                        // 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고,
                        queue.offer(new int[]{i, j, m, s, 0});
                        queue.offer(new int[]{i, j, m, s, 2});
                        queue.offer(new int[]{i, j, m, s, 4});
                        queue.offer(new int[]{i, j, m, s, 6});
                    } else {                                    // 그렇지 않으면 1, 3, 5, 7이 된다.
                        queue.offer(new int[]{i, j, m, s, 1});
                        queue.offer(new int[]{i, j, m, s, 3});
                        queue.offer(new int[]{i, j, m, s, 5});
                        queue.offer(new int[]{i, j, m, s, 7});
                    }
                }
            }
        }

        while (!queue.isEmpty())
            answer += queue.poll()[2];
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
