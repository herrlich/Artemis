public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int buy = prices[0], sell = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > sell) {
                sell = prices[i];
                profit = Math.max(profit, sell - buy);
                continue;
            }
            if (prices[i] < buy) {
                buy = prices[i];
                sell = prices[i];
            }
        }
        return profit;
    }
}

//Another method
public class Solution {
    public static int maxProfit(int[] prices) {
    	if (prices.length == 0) return 0;
        int res = 0;
        int maxvalue = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; --i) {
        	maxvalue = Math.max(maxvalue, prices[i]);
        	res = Math.max(res, maxvalue - prices[i]);
        }
        return res;
    }
}