public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() < 0) return 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1); map.put('X', 10); map.put('C', 100);
        map.put('M', 1000); map.put('V', 5); map.put('L', 50); map.put('D', 500);

        int res = 0;
        int n1 = map.get(s.charAt(0));
        int n2 = n1;
        for (int i = 0; i < s.length() - 1; ++i) {
            n2 = map.get(s.charAt(i + 1));
            if (n1 >= n2) res += n1;
            else res -= n1;
            n1 = n2;
        }
        return res + map.get(s.charAt(s.length() - 1));
    }
}