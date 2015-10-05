public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int start = 0, end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            while (!((s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= '0' && s.charAt(start) <= '9'))) {
                if (start >= end) return true;
                ++start;
            }
            while (!((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= '0' && s.charAt(end) <= '9'))) {
                if (start >= end) return true;
                --end;
            }
            if (s.charAt(start) != s.charAt(end)) return false;
            ++start;
            --end;
        }
        return true;
    }
}