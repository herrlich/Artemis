public class Solution {
    public String getHint(String secret, String guess) {
        String res = "";
        int a = 0, b = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++a;
                continue;
            }
            int tmp = secret.charAt(i) - '0';
            if (map.containsKey(tmp)) {
                int val = map.get(tmp);
                map.put(tmp, val + 1);
            }
            else map.put(tmp, 1);
        }
        
        for (int i = 0; i < guess.length(); ++i) {
            int tmp = guess.charAt(i) - '0';
            if (map.containsKey(tmp)) {
                if (secret.charAt(i) != guess.charAt(i) && map.get(tmp) > 0) {
                    ++b;
                    int val = map.get(tmp);
                    map.put(tmp, val - 1);
                }
            }
        }
        res += String.valueOf(a) + "A" + String.valueOf(b) + "B";
        return res;
    }
}