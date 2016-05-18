public class Solution {
    public static boolean isPalindrome(int x) {
    	if (x < 0) return false;
        int len = 1;
        int tmp = x;
        while (tmp / 10 > 0) {
        	len *= 10;
        	tmp = tmp / 10;
        }
        while (x != 0) {
        	int left = x / len;
        	int right = x % 10;
        	if (left != right) return false;
        	x = (x % len) / 10;
        	len = len / 100;
        }
        return true;
    }
}

-------------------------------------------------------------------
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int len = 0, tmp = x;
        int sum = 0;
        while (tmp != 0) {
            tmp = tmp / 10;
            ++len;
        }
        tmp = x;
        while (tmp != 0) {
            sum = sum * 10 + (tmp % 10);
            tmp = tmp / 10;
        }
        return (sum == x);
    }
}