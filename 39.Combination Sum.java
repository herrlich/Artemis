public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (candidates == null) return list;
        Arrays.sort(candidates);
        getCom(candidates, target, list, new ArrayList<Integer>(), 0);
        return list;
    }
    
    public void getCom(int[] candidates, int target, List<List<Integer>> list, List<Integer> tmp, int start) {
        for (int i = start; i < candidates.length; ++i) {
            if (candidates[i] > target) return;
            tmp.add(candidates[i]);
            if (candidates[i] == target) {
                List<Integer> cur = new ArrayList<Integer>(tmp);
                list.add(cur);
            }
            else getCom(candidates, target - candidates[i], list, tmp, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}