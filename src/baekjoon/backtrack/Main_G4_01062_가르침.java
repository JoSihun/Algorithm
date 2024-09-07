package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G4_01062_가르침 {
    public static int N, K;
    public static int answer;
    public static int bitmask;
    public static int[] wordbits;

    public static int word2bit(String word) {
        int wordbit = 0;
        for (char letter : word.toCharArray())
            wordbit |= (1 << (letter - 'a'));
        return wordbit;
    }

    public static void backtrack(int start, int depth) {
        if (depth == K - 5) {
            answer = Math.max(answer, countReadableWord());
            return;
        }

        for (int i = start; i < 26; i++) {
            if ((bitmask & (1 << i)) == 0) {
                bitmask |= (1 << i);
                backtrack(i + 1, depth + 1);
                bitmask &= ~(1 << i);
            }
        }
    }

    public static int countReadableWord() {
        int count = 0;
        for (int wordbit : wordbits)
            if ((wordbit & bitmask) == wordbit) count++;
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K >= 5) {
            wordbits = new int[N];
            for (int i = 0; i < N; i++)
                wordbits[i] = word2bit(br.readLine());

            bitmask |= (1 << ('a' - 'a'));
            bitmask |= (1 << ('n' - 'a'));
            bitmask |= (1 << ('t' - 'a'));
            bitmask |= (1 << ('i' - 'a'));
            bitmask |= (1 << ('c' - 'a'));
            backtrack(0, 0);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
