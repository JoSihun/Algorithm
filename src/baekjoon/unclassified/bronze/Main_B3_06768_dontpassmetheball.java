package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B3_06768_dontpassmetheball {
    private static int N;
    private static int answer;

    public static void combination(int cnt, int start, int[] arr) {
        if (cnt == 3) {
            if (arr[0] < arr[1] && arr[1] < arr[2])
                answer++;
            return;
        }

        for (int i = start; i < N - 1; i++) {
            arr[cnt] = i;
            combination(cnt + 1, i + 1, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        answer = 0;
        if (N >= 4) {
            combination(0, 0, new int[3]);
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
