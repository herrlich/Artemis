public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int house = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[house][k];
        for (int i = 0; i < k; ++i) dp[0][i] = costs[0][i];
        for (int i = 1; i < house; ++i) {
            int min = Integer.MAX_VALUE;
            int secmin = Integer.MAX_VALUE;
            for (int j = 0; j < k; ++j) {
                if (dp[i - 1][j] < min) {
                    secmin = min;
                    min = dp[i - 1][j];
                }
                else if (dp[i - 1][j] < secmin) {
                    secmin = dp[i - 1][j];
                }
            }
            
            for (int j = 0; j < k; ++j) {
                if (dp[i - 1][j] == min) {
                    dp[i][j] = secmin + costs[i][j];
                }
                else dp[i][j] = min + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; ++i) res = Math.min(res, dp[house - 1][i]);
        return res;
    }
}