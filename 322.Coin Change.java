public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0) return -1;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            dp[i] = -1;
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] > i) break;
                if (dp[i - coins[j]] == -1) continue;
                if (dp[i] == -1) dp[i] = 1 + dp[i - coins[j]];
                else dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return dp[amount];
    }
}