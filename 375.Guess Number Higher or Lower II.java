public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= n - i; ++j) {
                int t = i + j; // we should get the value of [j, t]
                int cost = Integer.MAX_VALUE;
                for (int k = j; k < t; ++k) {
                    int tmp = Math.max(k + dp[j][k - 1], k + dp[k + 1][t]);
                    cost = Math.min(cost, tmp);
                }
                dp[j][t] = Math.min(cost, dp[j][t - 1] + t);
            }
        }
        return dp[1][n];
    }
}