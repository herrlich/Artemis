public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return list;
        getPermute(nums, 0, list);
        return list;
    }
    
    public void getPermute(int[] nums, int start, List<List<Integer>> list) {
        if (start == nums.length - 1) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; ++i) cur.add(nums[i]);
            list.add(cur);
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            if (checkRepeat(nums, start, i)) continue;
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            getPermute(nums, start + 1, list);
            nums[i] = nums[start];
            nums[start] = tmp;
        }
    }
    
    public boolean checkRepeat(int[] nums, int start, int i) {
        for (int j = start; j < i; ++j) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
        return false;
    }
}