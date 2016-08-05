Write a function to generate the generalized abbreviations of a word.

Example:


Given word = "word", return the following list (order does not matter):

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]


public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<String>();
        if (word == null) return list;
        if (word.length() == 0) {
            list.add("");
            return list;
        }
        int len = word.length();
        for (int i = 0; i < Math.pow(2, len); ++i) {
            StringBuilder sb = new StringBuilder();
            int count = 0, j = 0;
            int val = i;
            while (j < len) {
                if ((val & 1) == 0) ++count;
                else {
                    if (count != 0) sb.insert(0, count);
                    sb.insert(0, word.charAt(len - 1 - j));
                    count = 0;
                }
                ++j;
                val >>= 1;
            }
            if (count != 0) sb.insert(0, count);
            list.add(new String(sb));
        }
        return list;
    }
}