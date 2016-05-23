public class Solution {
    public String reverseWords(String s) {
        if (s == null) return s;
        String[] words = s.trim().split(" +");
        if (words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; --i) sb.append(words[i] + " ");
        sb.append(words[0]);
        return new String(sb);
    }
}

------------------------------------------------------------------------------------

public class Solution {
    public String reverseWords(String s) {
        if (s == null) return s;
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0;
        while (start < s.length()) {
            while (start < s.length() && s.charAt(start) == ' ') ++start;
            if (start >= s.length()) break;
            for (end = start + 1; end < s.length(); ++end) {
                if (s.charAt(end) == ' ') break;
            }
            sb.insert(0, s.substring(start, end) + " ");
            start = end + 1;
        }
        String res = new String(sb);
        if (res.length() == 0) return "";
        return res.substring(0, res.length() - 1);
    }
}