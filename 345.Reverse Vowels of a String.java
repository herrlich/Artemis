public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        Set<Character> set = new HashSet<Character>();
        set.add('a'); set.add('A'); set.add('e'); set.add('E'); set.add('i'); 
        set.add('I'); set.add('o'); set.add('O'); set.add('u'); set.add('U');
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = s.length() - 1;
        while (p1 < p2) {
            while (p1 < p2 && !set.contains(s.charAt(p1))) {
                sb.insert(p1, s.charAt(p1));
                ++p1;
            }
            if (p1 >= p2) break;
            while (p1 < p2 && !set.contains(s.charAt(p2))) {
                sb.insert(p1, s.charAt(p2));
                --p2;
            }
            if (p1 >= p2) break;
            sb.insert(p1, s.charAt(p2--));
            sb.insert(p1 + 1, s.charAt(p1++));
        }
        if (p1 == p2) sb.insert(p1, s.charAt(p1));
        return new String(sb);
    }
}