package baekjoon.unclassified;

import java.io.*;
import java.util.*;

public class Main_G3_01644_소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for (int num = 2; num * num <= N; num++) {
            if (isPrime[num])
                for (int i = num * num; i <= N; i += num)
                    isPrime[i] = false;
        }

        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= N; num++)
            if (isPrime[num]) primes.add(num);

        int left = 0, right = 0, sum = 0, count = 0;
        while (true) {
            if (sum >= N) sum -= primes.get(left++);
            else if (right == primes.size()) break;
            else sum += primes.get(right++);
            if (sum == N) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
