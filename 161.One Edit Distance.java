Given two strings S and T, determine if they are both one edit distance apart.

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
        int len = Math.min(s.length(), t.length());
        boolean flag = false;
        int p1 = 0, p2 = 0;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(p1) == t.charAt(p2)) {
                ++p1;
                ++p2;
            }
            else {
                if (flag) return false;
                else {
                    if (s.length() == len) ++p2;
                    if (t.length() == len) ++p1;
                    flag = true;
                }
            }
        }
        return (p1 == p2) || ((!flag) || s.charAt(p1) == t.charAt(p2));
    }
}