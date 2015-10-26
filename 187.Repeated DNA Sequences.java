public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Character, Integer> chmap = new HashMap<Character, Integer>();
        chmap.put('C', 0); chmap.put('T', 1);
        chmap.put('A', 2); chmap.put('G', 3);
        int num = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i < 9) num = (num << 2) + chmap.get(s.charAt(i));
            else {
                num = (num << 2) + chmap.get(s.charAt(i));
                num &= (1 << 20) - 1;
                if (!map.containsKey(num)) map.put(num, 1);
                else {
                    int val = map.get(num);
                    if (val == 1) res.add(s.substring(i - 9, i + 1));
                    map.put(num, val + 1);
                }
            }
        }
        return res;
    }
}