public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<String>();
        if (digits == null || digits.length() <= 0) return list;
        list.add("");
        String[] map = new String[10];
        map[0] = ""; map[1] = ""; map[2] = "abc"; map[3] = "def";
        map[4] = "ghi"; map[5] = "jkl"; map[6] = "mno";
        map[7] = "pqrs"; map[8] = "tuv"; map[9] = "wxyz";
        for (int i = 0; i < digits.length(); ++i) {
            int len = list.size();
            int num = digits.charAt(i) - '0';
            for (int j = 0; j < len; ++j) {
                String s = list.poll();
                for (int k = 0; k < map[num].length(); ++k) {
                    list.offer(s + map[num].charAt(k));
                }
            }
        }
        return list;
    }
}