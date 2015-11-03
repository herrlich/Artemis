public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length + 1];
        int[] min = new int[nums.length + 1];
        max[0] = 1;
        min[0] = 1;
        for (int i = 1; i <= nums.length; ++i) {
            int num1 = max[i - 1] * nums[i - 1];
            int num2 = min[i - 1] * nums[i - 1];
            max[i] = Math.max(nums[i - 1], Math.max(num1, num2));
            min[i] = Math.min(nums[i - 1], Math.min(num1, num2));
        }
        int res = nums[0];
        for (int i = 1; i <= nums.length; ++i) res = Math.max(res, max[i]);
        return res;
    }
}