public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (p.equals("")) return s.equals("");
        if (s.equals("") && !(p.length() > 1 && p.charAt(1) == '*')) return false;
        if (p.length() == 1) {
            if (s.length() == 1 && (p.equals(".") || p.equals(s))) return true;
            else return false;
        }
        if (p.charAt(1) != '*') {
            if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) return isMatch(s.substring(1), p.substring(1));
            else return false;
        }
        else {
            if (isMatch(s, p.substring(2))) return true;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.') {
                    if (isMatch(s.substring(i + 1), p.substring(2))) return true;
                    else continue;
                }
                else break;
            }
            return false;
        }
    }
}