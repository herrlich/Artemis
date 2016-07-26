public class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = i;
            int j = 1;
            while (j * j <= i) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                ++j;
            }
        }
        return dp[n];
    }
}