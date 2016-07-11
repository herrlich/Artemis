public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char tmp;
        for (int i = 0; i < s.length(); ++i) {
            tmp = s.charAt(i);
            if (map.containsKey(tmp)) map.put(tmp, map.get(tmp) + 1);
            else map.put(tmp, 1);
        }
        for (int i = 0; i < t.length(); ++i) {
            tmp = t.charAt(i);
            if (map.containsKey(tmp)) map.put(tmp, map.get(tmp) - 1);
            else return false;
        }
        for (char c : map.keySet()) {
            if (map.get(c) != 0) return false;
        }
        return true;
    }
}

---------------------------------------------------------------------
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return String.valueOf(sarr).equals(String.valueOf(tarr));  
    }
}