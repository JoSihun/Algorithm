package BOJ.silver;

import java.io.*;
import java.util.Arrays;

public class Silver4_18110_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println("0");
            return;
        }

        int[] opinions = new int[N];
        for (int i = 0; i < N; i++)
            opinions[i] = Integer.parseInt(br.readLine());
        Arrays.sort(opinions);

        int answer = 0;
        int threshold = (int) Math.round(N * 0.15);
        for (int i = threshold; i < N - threshold; i++)
            answer += opinions[i];

        answer = (int) Math.round((double) answer / (N - 2 * threshold));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
