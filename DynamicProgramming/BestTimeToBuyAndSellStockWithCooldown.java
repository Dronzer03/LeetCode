package DynamicProgramming;

// LC - 309
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
public class BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][2];
        return maxPossibleProfit(prices, 0, 0, 0, dp);
    }

    private static int maxPossibleProfit(int[] prices, int index, int buy, int cap, Integer[][][] dp) {
        if (index == prices.length)
            return 0;

        if (dp[index][buy][cap] != null)
            return dp[index][buy][cap];

        int profit = 0;
        if (cap == 1) {
            profit = maxPossibleProfit(prices, index + 1, 0, 0, dp);
        }
        else if (buy == 0) {
            profit = Math.max(
                    - prices[index] + maxPossibleProfit(prices, index + 1, 1, 0, dp),
                    maxPossibleProfit(prices, index + 1, 0, 0, dp)
            );
        } else {
            profit = Math.max(
                    prices[index] + maxPossibleProfit(prices, index + 1, 0, 1, dp),
                    maxPossibleProfit(prices, index + 1, 1, 0, dp)
            );
        }

        return dp[index][buy][cap] = profit;
    }
}
