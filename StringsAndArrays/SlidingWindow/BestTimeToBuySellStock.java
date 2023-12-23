package StringsAndArrays.SlidingWindow;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;

        int profit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                profit = Math.max(profit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = prices[i] - prices[i-1] > 0 ? maxProfit + prices[i] - prices[i-1] : maxProfit;
        }
        return maxProfit;
    }
}
