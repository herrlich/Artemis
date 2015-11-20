public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int start = 0, end = 0;
        String res = "";
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (tmap.containsKey(c)) tmap.put(c, tmap.get(c) + 1);
            else {
                smap.put(c, 0);
                tmap.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (smap.containsKey(c)) {
                if (smap.get(c) < tmap.get(c)) end = i;
                smap.put(c, smap.get(c) + 1);
            }
        }
        for (char c : smap.keySet()) {
            if (smap.get(c) < tmap.get(c)) return "";
            else smap.put(c, 0);
        }
        for (int i = 0; i <= end; ++i) {
            char c = s.charAt(i);
            if (smap.containsKey(c)) smap.put(c, smap.get(c) + 1);
        }
        while (start <= end) {
            char c = s.charAt(start);
            if (smap.containsKey(c)) {
                smap.put(c, smap.get(c) - 1);
                if (smap.get(c) < tmap.get(c)) break;
            }
            ++start;
        }
        res = s.substring(start, ++end);
        char tmp = s.charAt(start++);
        while (end < s.length()) {
            char ctmp = s.charAt(end);
            if (smap.containsKey(ctmp)) {
                smap.put(ctmp, smap.get(ctmp) + 1);
                if (tmp == ctmp) {
                    while (start <= end) {
                        char c = s.charAt(start);
                        if (smap.containsKey(c)) {
                            smap.put(c, smap.get(c) - 1);
                            if (smap.get(c) < tmap.get(c)) break;
                        }
                        ++start;
                    }
                    if (end + 1 - start < res.length()) res = s.substring(start, end + 1);
                    tmp = s.charAt(start++);
                }
            }
            ++end;
        }
        return res;
    }
}