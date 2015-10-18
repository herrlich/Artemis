public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        return getCount(s, n);
    }
    
    private String getCount(String s, int n) {
        if (n == 1) return s;
        StringBuilder sb = new StringBuilder();
        int span = 1;
        char cur = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) ++span;
            else {
                sb.append(String.valueOf(span));
                sb.append(String.valueOf(cur));
                span = 1;
                cur = s.charAt(i);
            }
        }
        sb.append(String.valueOf(span));
        sb.append(String.valueOf(cur));
        return getCount(new String(sb), n - 1);
    }
}

//Another iteration method
public class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        String s = "1";
        for (int i = 1; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            int span = 1;
            char cur = s.charAt(0);
            for (int j = 1; j < s.length(); ++j) {
                if (s.charAt(j) == s.charAt(j - 1)) ++span;
                else {
                    sb.append(String.valueOf(span));
                    sb.append(String.valueOf(cur));
                    span = 1;
                    cur = s.charAt(j);
                }
            }
            sb.append(String.valueOf(span));
            sb.append(String.valueOf(cur));
            s = new String(sb);
        }
        return s;
    }
}