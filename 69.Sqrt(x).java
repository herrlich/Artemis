public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int left = 1, right = 46340;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid * mid == x) return mid;
            if (mid * mid < x) left = mid + 1;
            else right = mid - 1;
        }
        if (left * left <= x) return left;
        else return left - 1;
    }
}