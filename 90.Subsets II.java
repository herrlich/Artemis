public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        list.add(new ArrayList<Integer>());
        List<List<Integer>> last = null;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                List<List<Integer>> tmp = new ArrayList<List<Integer>>();
                for (List<Integer> l : last) {
                    List<Integer> cur = new ArrayList<Integer>(l);
                    cur.add(nums[i]);
                    tmp.add(cur);
                }
                list.addAll(tmp);
                last = tmp;
            }
            else {
                last = new ArrayList<List<Integer>>();
                for (List<Integer> l : list) {
                    List<Integer> cur = new ArrayList<Integer>(l);
                    cur.add(nums[i]);
                    last.add(cur);
                }
                list.addAll(last);
            }
        }
        return list;
    }
}