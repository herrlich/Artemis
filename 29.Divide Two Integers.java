public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;
            if (divisor == -1) return Integer.MAX_VALUE;
        }
        boolean neg = (dividend >= 0) ^ (divisor >= 0);
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
        long res = 0;
        while (divid >= divis) {
            int i = 0;
            long k = divis;
            while (divid >= k) {
                k <<= 1;
                ++i;
            }
            res += (1 << (i - 1));
            divid -= (k >> 1);
        }
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)((neg)? -res : res);
    }
}