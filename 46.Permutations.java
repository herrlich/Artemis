public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        getPermutation(nums, 0, res);
        return res;
    }
    
    public void getPermutation(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; ++i) list.add(nums[i]);
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            getPermutation(nums, start + 1, res);
            nums[i] = nums[start];
            nums[start] = tmp;
        }
    }
}