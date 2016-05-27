public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        int pos = 0, len = needle.length();
        for (int i = 0; i <= haystack.length() - len; ++i) {
            pos = 0;
            while (pos < len) {
                if (haystack.charAt(i + pos) == needle.charAt(pos)) ++pos;
                else break;
            }
            if (pos == len) return i;
        }
        return -1;
    }
}