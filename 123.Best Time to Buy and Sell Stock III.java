public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] front = new int[prices.length];
        int[] end = new int[prices.length];
        int max = prices[0], min = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] > max) {
                profit = Math.max(profit, prices[i] - min);
                max = prices[i];
            }
            if (prices[i] < min) {
                max = prices[i];
                min = prices[i];
            }
            front[i] = profit;
        }
        max = prices[prices.length - 1];
        profit = 0;
        for (int i = prices.length - 1; i >= 0; --i) {
            if (prices[i] > max) max = prices[i];
            profit = Math.max(profit, max - prices[i]);
            end[i] = profit;
        }
        max = 0;
        for (int i = 0; i < prices.length; ++i) {
            max = Math.max(max, front[i] + end[i]);
        }
        return max;
    }
}

-------------------------------------------------------------------------
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int tmp = prices[0];
        
        int curmax = 0;
        for (int i = 0; i < prices.length; ++i) {
            tmp = Math.min(prices[i], tmp);
            curmax = Math.max(curmax, prices[i] - tmp);
            left[i] = curmax;
        }
        
        curmax = 0;
        tmp = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; --i) {
            tmp = Math.max(prices[i], tmp);
            curmax = Math.max(curmax, tmp - prices[i]);
            right[i] = curmax;
        }
        
        curmax = 0;
        for (int i = 0; i < prices.length; ++i) {
            curmax = Math.max(curmax, left[i] + right[i]);
        }
        return curmax;
    }
}