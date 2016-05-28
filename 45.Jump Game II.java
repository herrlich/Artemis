public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int[] dp = new int[nums.length];
        int maxpos = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i + nums[i] >= nums.length - 1) return dp[i] + 1;
            for (int j = i + nums[i]; j >= maxpos + 1; --j) dp[j] = dp[i] + 1;
            maxpos = Math.max(i + nums[i], maxpos);
        }
        return dp[nums.length - 1];
    }
}