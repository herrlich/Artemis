public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}