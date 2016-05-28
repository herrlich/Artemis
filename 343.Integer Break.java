DP method

public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2; dp[3] = 3;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i / 2; ++j) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[n];
    }
}

-----------------------------------------------------------------------
O(n) method

public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int res = 1;
        while (n >= 5) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}