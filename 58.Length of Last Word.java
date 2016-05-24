public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = 0, pos = s.length() - 1;
        while (pos >= 0) {
            if (s.charAt(pos) == ' ') --pos;
            else break;
        }
        if (pos < 0) return 0;
        for (int i = pos; i >= 0; --i) {
            if (s.charAt(i) == ' ') break;
            ++len;
        }
        return len;
    }
}

-------------------------------------------------------------------------
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] words = s.split(" +");
        if (words.length < 1) return 0;
        return words[words.length - 1].length();
    }
}