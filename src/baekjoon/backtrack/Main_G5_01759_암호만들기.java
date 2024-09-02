package baekjoon.backtrack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_01759_암호만들기 {
    public static int L, C;
    public static char[] password;
    public static char[] alphabets;
    public static StringBuilder sb;

    public static void backtrack(int index, int start) {
        if (index == L) {
            if (isValid())
                sb.append(password).append("\n");
            return;
        }

        for (int i = start; i < C; i++) {
            password[index] = alphabets[i];
            backtrack(index + 1, i + 1);
        }
    }

    public static boolean isValid() {
        int vowels = 0, consonants = 0;
        for (char c : password) {
            if (isVowel(c)) vowels++;
            else consonants++;
        }
        return vowels >= 1 && consonants >= 2;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(alphabets);

        password = new char[L];
        backtrack(0, 0);

        bw.write(sb.toString());
        bw.flush();
    }
}
