public class Solution {
    public int reverse(int x) {
        int flag = 1;
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0) flag = -1;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            int num = x % 10;
            if (res > (Integer.MAX_VALUE - num) / 10) return 0;
            res = res * 10 + num;
            x /= 10;
        }
        return res * flag;
    }
}