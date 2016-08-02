public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n) return list;
        getList(list, n, k, 1, new ArrayList<Integer>());
        return list;
    }
    
    public void getList(List<List<Integer>> list, int n, int k, int start, List<Integer> tmp) {
        if (k == 0) {
            List<Integer> cur = new ArrayList<Integer>(tmp);
            list.add(cur);
            return;
        }
        for (int i = start; i <= n; ++i) {
            tmp.add(i);
            getList(list, n, k - 1, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}