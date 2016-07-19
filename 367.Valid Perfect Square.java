public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        int left = 0, right = 46340;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == num) return true;
            if (mid * mid > num) right = mid - 1;
            else left = mid + 1;
        }
        return left * left == num;
    }
}