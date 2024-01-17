package DynamicProgramming;

public class BestTimeToBuyAndSellStockWithFee {
    private static int TxnFee;
    public static int maxProfit(int[] prices, int fee) {
        TxnFee = fee;
        Integer[][] dp = new Integer[prices.length][2];
        return maxPossibleProfit(prices, 0, 0, dp);
    }

    private static int maxPossibleProfit(int[] prices, int index, int buy, Integer[][] dp) {
        if (index == prices.length)
            return 0;

        if (dp[index][buy] != null)
            return dp[index][buy];

        int profit = 0;
        if (buy == 0) {
            profit = Math.max(
                    -prices[index] + maxPossibleProfit(prices, index + 1, 1, dp),
                    maxPossibleProfit(prices, index + 1, 0, dp)
            );
        } else {
            profit = Math.max(
                    prices[index] - TxnFee + maxPossibleProfit(prices, index + 1, 0, dp),
                    maxPossibleProfit(prices, index + 1, 1, dp)
            );
        }

        return dp[index][buy] = profit;
    }
}
