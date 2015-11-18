public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int tmp = Math.abs(target - res);
        for (int i = 0; i < nums.length; ++i) {
            //We cannot judge if (nums[i] > target) then break here. Since the target may be negative.
            //e.g. -1 > -5(target), but -1 + (-2) + (-2) == -5;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                while (left > i + 1 && nums[left] == nums[left - 1] && left < right) ++left;
                if (left >= right) break;
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return target;
                if (Math.abs(target - sum) < tmp) {
                    res = sum;
                    tmp = Math.abs(target - sum);
                }
                if (sum > target) --right;
                else ++left;
            }
        }
        return res;
    }
}