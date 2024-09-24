package baekjoon.union_find;

import java.io.*;
import java.util.*;

public class Main_P5_02162_선분그룹 {
    public static int N;
    public static int[] size;
    public static int[] parent;

    public static class Line {
        int x1, y1, x2, y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void make() {
        Arrays.fill(size, 1);
        for (int i = 0; i < N; i++)
            parent[i] = i;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        // rootY가 더 크면 rootX를 rootY로 병합
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public static boolean isCross(Line line1, Line line2) {
        int ccw1 = ccw(line1.x1, line1.y1, line1.x2, line1.y2, line2.x1, line2.y1);
        int ccw2 = ccw(line1.x1, line1.y1, line1.x2, line1.y2, line2.x2, line2.y2);
        int ccw3 = ccw(line2.x1, line2.y1, line2.x2, line2.y2, line1.x1, line1.y1);
        int ccw4 = ccw(line2.x1, line2.y1, line2.x2, line2.y2, line1.x2, line1.y2);

        if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0)
                return isOverlap(line1, line2);
            return true;
        }
        return false;
    }

    public static boolean isOverlap(Line line1, Line line2) {
        return Math.min(line1.x1, line1.x2) <= Math.max(line2.x1, line2.x2)
                && Math.min(line2.x1, line2.x2) <= Math.max(line1.x1, line1.x2)
                && Math.min(line1.y1, line1.y2) <= Math.max(line2.y1, line2.y2)
                && Math.min(line2.y1, line2.y2) <= Math.max(line1.y1, line1.y2);
    }

    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = (long)(x2 - x1) * (y3 - y1) - (long)(x3 - x1) * (y2 - y1);
        return Long.compare(result, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            lines.add(new Line(x1, y1, x2, y2));
        }

        parent = new int[N];
        size = new int[N];
        make();

        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (isCross(lines.get(i), lines.get(j)))
                    union(i, j);

        int cntLine = 0, cntGroup = 0;
        for (int i = 0; i < N; i++) {
            if (find(i) == i) {
                cntGroup++;
                cntLine = Math.max(cntLine, size[i]);
            }
        }
        System.out.println(cntGroup + "\n" + cntLine);
    }
}
