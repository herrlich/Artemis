public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<String>();
        String[] phone = new String[10];
        phone[0] = ""; phone[1] = ""; phone[2] = "abc"; phone[3] = "def";
        phone[4] = "ghi"; phone[5] = "jkl"; phone[6] = "mno";
        phone[7] = "pqrs"; phone[8] = "tuv"; phone[9] = "wxyz";
        if (digits == null || digits.length() == 0) return list;
        String tmp = phone[digits.charAt(0) - '0'];
        for (int i = 0; i < tmp.length(); ++i) list.add(tmp.substring(i, i + 1));
        for (int i = 1; i < digits.length(); ++i) {
            tmp = phone[digits.charAt(i) - '0'];
            int len = list.size();
            for (int j = 0; j < len; ++j) {
                String cur = list.removeFirst();
                for (int k = 0; k < tmp.length(); ++k) {
                    list.add(cur + tmp.substring(k, k + 1));
                }
            }
        }
        return list;
    }
}