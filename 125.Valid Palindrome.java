public class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            while (start < end) {
                if ((str.charAt(start) >= 'a' && str.charAt(start) <= 'z') || (str.charAt(start) >= '0' && str.charAt(start) <= '9')) break;
                else ++start;
            }
            if (start >= end) break;
            while (start < end) {
                if ((str.charAt(end) >= 'a' && str.charAt(end) <= 'z') || (str.charAt(end) >= '0' && str.charAt(end) <= '9')) break;
                else --end;
            }
            if (start >= end) break;
            if (str.charAt(start) != str.charAt(end)) return false;
            ++start; --end;
        }
        return true;
    }
}