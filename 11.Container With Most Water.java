public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int p1 = 0, p2 = height.length - 1;
        int res = 0;
        while (p1 < p2) {
            res = Math.max(res, Math.min(height[p1], height[p2]) * (p2 - p1));
            if (height[p1] == height[p2]) {
                ++p1;
                --p2;
                continue;
            }
            if (height[p1] > height[p2]) --p2;
            else ++p1;
        }
        return res;
    }
}