public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        String res = "", tmp = null;
        for (int i = 0; i < s.length(); ++i) {
            tmp = getPalin(s, i, i);
            if (tmp.length() > res.length()) res = tmp;
            tmp = getPalin(s, i, i + 1);
            if (tmp.length() > res.length()) res = tmp;
        }
        return res;
    }
    
    public String getPalin(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return s.substring(left + 1, right);
    }
}