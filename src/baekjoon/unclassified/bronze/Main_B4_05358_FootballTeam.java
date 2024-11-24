package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_05358_FootballTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line; char temp = '\u0000';
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            sb.append(line
                    .replace('e', temp)
                    .replace('i', 'e')
                    .replace(temp, 'i')
                    .replace('E', temp)
                    .replace('I', 'E')
                    .replace(temp, 'I')
            ).append("\n");
        }
        System.out.println(sb);
    }
}
