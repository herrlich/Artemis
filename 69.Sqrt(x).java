public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int start = 1, end = x;
        while (start <= end) {
            long mid = (long)start + (end - start)  / 2;
            if (mid * mid == x) return (int)mid;
            if (mid * mid > x) end = (int)mid - 1;
            else start = (int)mid + 1;
        }
        return end;
    }
}