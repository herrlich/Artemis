/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length < 2) return points.length;
        int res = 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; ++i) {
            int same_x = 0, same_y = 0, same_point = 1;
            double slope = 0;
            int max_slope = 0, tmpmax = 0;
            map.clear();
            Point p1 = points[i];
            for (int j = i + 1; j < points.length; ++j) {
                Point p2 = points[j];
                if (p1.x == p2.x || p1.y == p2.y) {
                    if (p1.x == p2.x && p1.y == p2.y) ++same_point;
                    else {
                        if (p1.x == p2.x) ++same_x;
                        else ++same_y;
                    }
                }
                else {
                    slope = (double)(p1.y - p2.y) / (p1.x - p2.x);
                    if (map.containsKey(slope)) {
                        int tmpval = map.get(slope);
                        max_slope = Math.max(max_slope, tmpval + 1);
                        map.put(slope, tmpval + 1);
                    }
                    else {
                        map.put(slope, 1);
                        max_slope = Math.max(max_slope, 1);
                    }
                }
            }
            tmpmax = Math.max(same_x, same_y);
            tmpmax = Math.max(tmpmax, max_slope);
            res = Math.max(res, tmpmax + same_point);
        }
        return res;
    }
}