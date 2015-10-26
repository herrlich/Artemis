public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        int mid = n / 2;
        double half = myPow(x, mid);
        if (n % 2 == 0) return half * half;
        else {
            if (n > 0) return half * half * x;
            else return half * half * (1 / x);
        }
    }
}

//Another method using bit operation
public class Solution {
    public static double myPow(double x, int n) {
    	boolean flag = true, minInt = false;
    	if (n < 0) {
    		flag = false;
    		if (n == Integer.MIN_VALUE) {
    			n = Integer.MAX_VALUE;
    			minInt = true;
    		}
    		else n = - n;
    	}
    	double result = 1, tmp = x;
    	while (n != 0) {
    		if ((n & 1) > 0) result *= tmp;
    		tmp = tmp * tmp;
    		n >>= 1;
    	}
    	if (minInt) result *= x;
    	if (!flag) result = 1.0 / result;
    	return result;
    }
}