package baekjoon.union_find;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_G2_04195_친구네트워크 {
    public static int F;
    public static Map<String, Integer> size;
    public static Map<String, String> parent;

    public static String find(String x) {
        if (parent.get(x).equals(x)) return x;
        String p = find(parent.get(x));
        parent.put(x, p);
        return p;
    }

    public static void union(String x, String y) {
        String rootX = find(x);
        String rootY = find(y);
        if (rootX.equals(rootY)) return;

        if (size.get(rootX) > size.get(rootY)) {
            parent.put(rootY, rootX);
            size.put(rootX, size.get(rootX) + size.get(rootY));
        } else if (size.get(rootX) <= size.get(rootY)) {
            parent.put(rootX, rootY);
            size.put(rootY, size.get(rootX) + size.get(rootY));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        size = new HashMap<>();
        parent = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            F = Integer.parseInt(br.readLine());
            size.clear(); parent.clear();

            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!parent.containsKey(a)) {
                    parent.put(a, a);
                    size.put(a, 1);
                }

                if (!parent.containsKey(b)) {
                    parent.put(b, b);
                    size.put(b, 1);
                }

                union(a, b);
                sb.append(size.get(find(a))).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
