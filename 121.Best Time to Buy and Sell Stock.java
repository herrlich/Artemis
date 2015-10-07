public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        int min = prices[0], max = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > max) {
                max = prices[i];
                res = Math.max(res, max - min);
                continue;
            }
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }
        return res;
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