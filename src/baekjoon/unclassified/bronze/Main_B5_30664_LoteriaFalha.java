package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_B5_30664_LoteriaFalha {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            BigInteger N = new BigInteger(br.readLine());
            if (N.equals(BigInteger.ZERO)) return;

            System.out.println(N.mod(BigInteger.valueOf(42)).equals(BigInteger.ZERO)
                    ? "PREMIADO" : "TENTE NOVAMENTE");
        }
    }
}
