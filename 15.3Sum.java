public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length <= 2) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    if (left > i + 1 && nums[left] == nums[left -1]) {
                        ++left;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        --right;
                        continue;
                    }
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]); tmp.add(nums[left]); tmp.add(nums[right]);
                    res.add(tmp);
                    ++left; --right;
                }
                else {
                    if (nums[left] + nums[right] + nums[i] < 0)  ++left;
                    else --right;
                }
            }
        }
        return res;
    }
}