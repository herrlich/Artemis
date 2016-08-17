public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
                else break;
            }
        }
        return dp[target];
    }
}


// Follow up : we need to limit the number to be used of each negative number