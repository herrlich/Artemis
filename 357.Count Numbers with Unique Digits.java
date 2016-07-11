public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 10;
        for (int i = 2; i <= n; ++i) {
            dp[i] = permutation(i) + dp[i - 1];
        }
        return dp[n];
    }
    
    public int permutation(int n) {
        int res = 9;
        for (int i = 9; i > 10 - n; --i) res *= i;
        return res;
    }
}