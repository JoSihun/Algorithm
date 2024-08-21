package baekjoon.unclassified;

import java.io.*;
import java.util.StringTokenizer;

public class Main_G2_17387_선분교차2 {

    public static class Point {
        public long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int ccw(Point p1, Point p2, Point p3) {
        long result = (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
        if (result > 0) return 1;   // 반시계, 선분 (p1 - p2)의 왼편에 점 p3가 존재하는 경우
        if (result < 0) return -1;  // 정시계, 선분 (p1 - p2)의 오른편에 점 p3가 존재하는 경우
        return 0;   // 선분 (p1 - p2)의 일직선 상에 점 p3가 존재하는 경우
    }

    public static boolean isIntersect(Point p1, Point p2, Point p3, Point p4) {
        int ccw1 = ccw(p1, p2, p3);     // 선분 (p1 - p2)에서 점 p3 위치 판단
        int ccw2 = ccw(p1, p2, p4);     // 선분 (p1 - p2)에서 점 p4 위치 판단
        int ccw3 = ccw(p3, p4, p1);     // 선분 (p3 - p4)에서 점 p1 위치 판단
        int ccw4 = ccw(p3, p4, p2);     // 선분 (p3 - p4)에서 점 p2 위치 판단

        if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0) return true;        // 선분 (p1 - p2)와 선분 (p3 - p4)가 교차하는 경우
        if (ccw1 == 0 && onLineSegment(p1, p2, p3)) return true;    // 선분 (p1 - p2) 위에 점 p3가 위치하는 경우
        if (ccw2 == 0 && onLineSegment(p1, p2, p4)) return true;    // 선분 (p1 - p2) 위에 점 p4가 위치하는 경우
        if (ccw3 == 0 && onLineSegment(p3, p4, p1)) return true;    // 선분 (p3 - p4) 위에 점 p1가 위치하는 경우
        if (ccw4 == 0 && onLineSegment(p3, p4, p2)) return true;    // 선분 (p3 - p4) 위에 점 p2가 위치하는 경우
        return false;
    }

    public static boolean onLineSegment(Point p1, Point p2, Point p) {
        // 점 p가 선분 (p1 - p2) 위에 존재하는지 여부 판단
        return Math.min(p1.x, p2.x) <= p.x && p.x <= Math.max(p1.x, p2.x) &&
                Math.min(p1.y, p2.y) <= p.y && p.y <= Math.max(p1.y, p2.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        Point[] points = new Point[4];
        points[0] = new Point(x1, y1);
        points[1] = new Point(x2, y2);
        points[2] = new Point(x3, y3);
        points[3] = new Point(x4, y4);

        int answer = isIntersect(points[0], points[1], points[2], points[3]) ? 1 : 0;
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
