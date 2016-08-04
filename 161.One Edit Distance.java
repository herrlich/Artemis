public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        if (s.equals(t)) return false;
        int lens = s.length(), lent = t.length();
        if (Math.abs(lens - lent) > 1) return false;
        boolean oneedit = false;
        if (lens == lent) {
            for (int i = 0; i < lens; ++i) {
                if (s.charAt(i) == t.charAt(i)) continue;
                else {
                    if (oneedit) return false;
                    else oneedit = true;
                }
            }
            return true;
        }
        else {
            int len = Math.min(lens, lent);
            int si = 0, ti = 0;
            while (si < lens && ti < lent) {
                if (s.charAt(si) == t.charAt(ti)) {
                    ++si;
                    ++ti;
                }
                else {
                    if (oneedit) return false;
                    else {
                        oneedit = true;
                        if (lens == len) ++ti;
                        else ++si;
                    }
                }
            }
            return true;
        }
    }
}