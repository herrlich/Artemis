public class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
    	return num % 9;
    }
}

--------------------------------------------------------------------------

public class Solution {
    public int addDigits(int num) {
        int res = num, tmp = 0;
        while (res >= 10) {
            tmp = 0;
            while (res > 0) {
                tmp += (res % 10);
                res /= 10;
            }
            res = tmp;
        }
        return res;
    }
}
