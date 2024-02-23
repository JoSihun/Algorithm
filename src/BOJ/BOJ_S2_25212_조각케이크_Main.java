package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S2_25212_조각케이크_Main {
    private static int N;
    private static int[] c;
    private static int answer;

    public static void backtrack(int idx, double sum) {
        if (sum > 1.01)
            return;

        if (idx == N) {
            if (0.99 <= sum)
                answer++;
            return;
        }

        backtrack(idx + 1, sum);
        backtrack(idx + 1, sum + (1.0 / c[idx]));
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        c = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            c[i] = Integer.parseInt(st.nextToken());

        backtrack(0, 0);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
