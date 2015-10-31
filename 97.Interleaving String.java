public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[][][] dp = new boolean[len1 + 1][len2 + 1][len3 + 1];
        dp[0][0][0] = true;
        for (int i = 1; i < len1 + 1; ++i) {
            if (dp[i - 1][0][i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0][i] = true;
        }
        for (int i = 1; i < len2 + 1; ++i) {
            if (dp[0][i - 1][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1)) dp[0][i][i] = true;
        }
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (dp[i - 1][j][i + j - 1] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j][i + j] = true;
                }
                if (dp[i][j - 1][i + j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j][i + j] = true;
                }
            }
        }
        return dp[len1][len2][len3];
    }
}