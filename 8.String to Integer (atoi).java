public class Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;
        
        str = str.trim();
        if (str.length() == 0) return 0;
        
        double res = 0;
        int i = 0, flag = 1;
        
        if (str.charAt(0) == '-') {
            flag = -1;
            ++i;
        }
        else if (str.charAt(0) == '+') ++i;
        
        for (; i < str.length(); ++i) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') break;
            res = res * 10 + (str.charAt(i) - '0');
        }
        
        res *= flag;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }
}