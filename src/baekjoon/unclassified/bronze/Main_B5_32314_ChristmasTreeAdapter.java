package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_32314_ChristmasTreeAdapter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int treeAmpere = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int adapterWatt = Integer.parseInt(st.nextToken());
        int adapterVolt = Integer.parseInt(st.nextToken());

        int adapterAmpere = adapterWatt / adapterVolt;
        System.out.println(adapterAmpere >= treeAmpere ? 1 : 0);
    }
}
