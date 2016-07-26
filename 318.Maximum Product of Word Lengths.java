public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        int res = 0;
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                mask[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        
        for (int i = 0; i < words.length; ++i) {
            for (int j = i; j < words.length; ++j) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}