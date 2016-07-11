public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows < 1) return list;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        list.add(tmp);
        for (int i = 1; i < numRows; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 1; j < tmp.size(); ++j) {
                cur.add(tmp.get(j) + tmp.get(j - 1));
            }
            cur.add(1);
            list.add(cur);
            tmp = cur;
        }
        return list;
    }
}