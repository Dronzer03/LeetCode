package DynamicProgramming;

// LC - 123
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
public class BestTimeToBuyAndSellStock3 {
    public static int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][2];
        return maxPossibleProfit(prices, 0, 0, 0, dp);
    }

    private static int maxPossibleProfit(int[] prices, int index, int buy, int cap, Integer[][][] dp) {
        if (cap == 2)
            return 0;

        if (index == prices.length)
            return 0;

        if (dp[index][buy][cap] != null)
            return dp[index][buy][cap];

        int profit = 0;
        if (buy == 0) {
            profit = Math.max(
                    - prices[index] + maxPossibleProfit(prices, index + 1, 1, cap, dp),
                    maxPossibleProfit(prices, index + 1, 0, cap, dp)
            );
        } else {
            profit = Math.max(
                    prices[index] + maxPossibleProfit(prices, index + 1, 0, cap + 1, dp),
                    maxPossibleProfit(prices, index + 1, 1, cap, dp)
            );
        }

        return dp[index][buy][cap] = profit;
    }

    public static int maxProfitTabulated(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][4];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    if (buy == 1) {
                        dp[index][buy][cap] = Math.max(
                                -prices[index] + dp[index + 1][0][cap],
                                dp[index + 1][1][cap]
                        );
                    } else {
                        dp[index][buy][cap] = Math.max(
                                prices[index] + dp[index + 1][1][cap - 1],
                                dp[index + 1][0][cap]
                        );
                    }
                }
            }
        }

        return dp[0][1][2];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitTabulated(prices));
    }
}
