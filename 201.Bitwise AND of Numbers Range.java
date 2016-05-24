public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != 0 && n != 0) {
            if (m == n) return m << offset;
            m >>= 1;
            n >>= 1;
            ++offset;
        }
        return 0;
    }
}

-----------------------------------------------------------------------
public class Solution {
    public static int rangeBitwiseAnd(int m, int n) {
		if (m == 0) return 0;
		if (m == n) return m;
        int res = 0, tmp = 0;
        long left, right;
        int a = 0, b = 0;
        tmp = m;
        while (tmp != 0) {
        	tmp >>= 1;
        	++a;
        }
        tmp = n;
        while (tmp != 0) {
        	tmp >>= 1;
        	++b;
        }
        if (a != b) return 0;
        left = (long)Math.pow(2, a - 1);
        right = 2 * left;
        res = (int)left;
        long mid = (left + right) / 2;
        while (!(m < mid && n >= mid)) {
        	mid = (left + right) / 2;
        	if (m >= mid) {
        		left = mid;
        		res = (int)mid;
        	}
        	else right = mid;
        }
        return res;
    }
}