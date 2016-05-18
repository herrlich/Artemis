public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int left = 0, right = 0;
        int len = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                ++right;
            }
            else {
                len = Math.max(right - left, len);
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    ++left;
                }
                ++left;
                ++right;
            }
        }
        return Math.max(right - left, len);
    }
}


----------------------------------------------------------------------------------

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int left = 0, right = 0;
        int[] array = new int[256];
        for (right = 0; right < s.length(); ++right) {
            if (array[(int)s.charAt(right)] == 1) {
                res = Math.max(res, right - left);
                while (s.charAt(left) != s.charAt(right)) {
                    array[(int)s.charAt(left)] = 0;
                    ++left;
                }
                ++left;
            }
            else array[(int)s.charAt(right)] = 1;
        }
        res = Math.max(res, right - left);
        return res;
    }
}