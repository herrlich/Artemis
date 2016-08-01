public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return nums[0] + nums[1];
        int res = 0, offset = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == target) return target;
                if (Math.abs(target - tmp) < offset) {
                    offset = Math.abs(target - tmp);
                    res = tmp;
                }
                if (tmp < target) ++left;
                else --right;
            }
        }
        return res;
    }
}