public class Solution {
    public String getHint(String secret, String guess) {
        if (secret.length() != guess.length()) return "";
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        int numA = 0, numB = 0;
        for (int i = 0; i < secret.length(); ++i) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) ++numA;
            else {
                if (!map1.containsKey(c1)) map1.put(c1, 1);
                else map1.put(c1, map1.get(c1) + 1);
                if (!map2.containsKey(c2)) map2.put(c2, 1);
                else map2.put(c2, map2.get(c2) + 1);
            }
        }
        for (char i : map1.keySet()) {
            if (map2.containsKey(i)) numB += Math.min(map2.get(i), map1.get(i));
        }
        String s = numA + "A" + numB + "B";
        return s;
    }
}

// Another more effective method

public class Solution {
    public String getHint(String secret, String guess) {
        if (secret.length() != guess.length()) return "";
        int numA = 0, numB = 0;
        int[] arr = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            int c1 = secret.charAt(i) - '0';
            int c2 = guess.charAt(i) - '0';
            if (c1 == c2) ++numA;
            else {
                if (arr[c1]++ < 0) ++numB;
                if (arr[c2]-- > 0) ++numB;
            }
        }
        String s = numA + "A" + numB + "B";
        return s;
    }
}