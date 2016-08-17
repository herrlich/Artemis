/*This algorithm ultilizes the idea of backtracking.*/

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int st = 0, pt = 0;
        int sprev = 0, pprev = 0; //These are pointers that used to store the st and pt of an 'original' state.
        boolean star = false;
        while (st != s.length()) {
            if (pt == p.length()) {
                if (star) {
                    pt = pprev;
                    st = ++sprev;
                    continue;
                }
                else return false;
            }
            if (s.charAt(st) == p.charAt(pt) || p.charAt(pt) == '?') {
                ++st;
                ++pt;
                continue;
            }
            if (p.charAt(pt) == '*') {
                star = true;
                sprev = st;
                pprev = ++pt;
                continue;
            }
            if (star) {
                st = ++sprev;
                pt = pprev;
            }
            else return false;
        }

        for (int i = pt; i < p.length(); ++i) {
            if (p.charAt(i) != '*') return false;
        }
        return true;
    }
}
