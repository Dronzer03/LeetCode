package SlidingWindow;

// LC - 121
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
// LC - 122
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
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

    public static int maxProfit3 (int[] prices) {
        int min = prices[0];

        int maxProfit = 0;
        for (int index = 1; index < prices.length; index++) {
            if (prices[index] > min) {
                maxProfit = Math.max(maxProfit, prices[index] - min);
            }
            min = Math.min(min, prices[index]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit3(nums));
    }
}
