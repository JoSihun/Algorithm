package baekjoon.unclassified.bronze;

import java.io.*;

public class Main_B1_28702_FizzBuzz {

    public static String FizzBuzz(int num) {
        if (num % 15 == 0) return "FizzBuzz";
        else if (num % 3 == 0) return "Fizz";
        else if (num % 5 == 0) return "Buzz";
        return String.valueOf(num);
    }

    public static int findAnswer(String[] numbers) {
        for (int i = 2; i >= 0; i--)
            if (isNumeric(numbers[i]))
                return Integer.parseInt(numbers[i]) + (3 - i);
        return 4;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = new String[3];
        for (int i = 0; i < 3; i++)
            numbers[i] = br.readLine().trim();

        int answer = findAnswer(numbers);
        bw.write(FizzBuzz(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
