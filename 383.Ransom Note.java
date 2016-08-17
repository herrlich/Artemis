public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); ++i) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                int num = map.get(c);
                if (num == 0) return false;
                else map.put(c, num - 1);
            }
            else return false;
        }
        return true;
    }
}