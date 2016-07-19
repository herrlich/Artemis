public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        String[] array = str.split(" ");
        if (pattern.length() != array.length) return false;
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            if (map1.containsKey(c)) {
                if (!map1.get(c).equals(array[i])) return false;
            } 
            else map1.put(c, array[i]);
            if (map2.containsKey(array[i])) {
                if (map2.get(array[i]) != c) return false;
            }
            else map2.put(array[i], c);
        }
        return true;
    }
}