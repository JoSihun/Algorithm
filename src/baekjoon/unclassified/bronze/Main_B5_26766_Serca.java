package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_26766_Serca {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String serca = " @@@   @@@ \n" +
                "@   @ @   @\n" +
                "@    @    @\n" +
                "@         @\n" +
                " @       @ \n" +
                "  @     @  \n" +
                "   @   @   \n" +
                "    @ @    \n" +
                "     @     ";
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0)
            System.out.println(serca);
    }
}
