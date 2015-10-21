/*
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color. 

Return the total number of ways you can paint the fence. 

Note:
 n and k are non-negative integers. 
*/
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        int[][][] dp = new int[2][k][2];
        
        for (int i = 0; i < k; ++i) {
            dp[0][i][0] = 1;//0表示和前面的fence不同颜色
            dp[0][i][1] = 0;//1表示和前面的fence相同颜色
        }
        
        for (int i = 1; i < n; ++i) {
            int sum = 0;
            for (int j = 0; j < k; ++j) sum += (dp[(i - 1) % 2][j][0] + dp[(i - 1) % 2][j][1]);
            for (int j = 0; j < k; ++j) {
                dp[i % 2][j][1] = dp[(i - 1) % 2][j][0];
                dp[i % 2][j][0] = sum - dp[(i - 1) % 2][j][1] - dp[(i - 1) % 2][j][0];
            }
        }
        
        int res = 0;
        for (int i = 0; i < k; ++i) res += (dp[(n - 1) % 2][i][0] + dp[(n - 1) % 2][i][1]);
        return res;
    }
}

