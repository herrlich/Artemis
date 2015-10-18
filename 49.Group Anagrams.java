public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if (strs == null || strs.length == 0) return res;
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; ++i) {
            String tmp = reformat(strs[i]);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(strs[i]);
            }
            else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(tmp, list);
            }
        }
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }
    
    private String reformat(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}