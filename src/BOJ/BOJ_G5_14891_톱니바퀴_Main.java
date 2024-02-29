package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G5_14891_톱니바퀴_Main {
    private static int K;
    private static int answer;
    private static char[][] wheel;

    public static void dfs(int num, int dir, boolean[] visited) {
        visited[num] = true;
        if (num == 0) {
            if (wheel[num][2] != wheel[num + 1][6] && !visited[num + 1])
                dfs(num + 1, -dir, visited);
        } else if (num == 3) {
            if (wheel[num][6] != wheel[num - 1][2] && !visited[num - 1])
                dfs(num - 1, -dir, visited);
        } else {
            if (wheel[num][2] != wheel[num + 1][6] && !visited[num + 1])
                dfs(num + 1, -dir, visited);
            if (wheel[num][6] != wheel[num - 1][2] && !visited[num - 1])
                dfs(num - 1, -dir, visited);
        }
        rotate(num, dir);
    }

    public static void rotate(int num, int dir) {
        if (dir == 1) {
            char temp = wheel[num][7];
            for (int i = 7; i > 0; i--)
                wheel[num][i] = wheel[num][i - 1];
            wheel[num][0] = temp;
        } else if (dir == -1) {
            char temp = wheel[num][0];
            for (int i = 0; i < 7; i++)
                wheel[num][i] = wheel[num][i + 1];
            wheel[num][7] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        wheel = new char[4][8];
        for (int i = 0; i < 4; i++)
            wheel[i] = br.readLine().toCharArray();

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            dfs(num - 1, dir, new boolean[4]);
        }

        answer = 0;
        for (int i = 0; i < 4; i++)
            answer += (wheel[i][0] - '0') * (1 << i);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
