package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[amount+1][coins.length];
        Arrays.sort(coins);
        int result = minCoins(coins, amount, 0, dp);
        return result >= 10001 ? -1 : result;
    }

    private static int minCoins(int[] coins, int amount, int index, Integer[][] dp) {
        if (amount == 0)
            return 0;

        if (amount < 0 || index == coins.length)
            return 10001;

        if (dp[amount][index] != null)
            return dp[amount][index];

        int take = 1 + minCoins(coins, amount - coins[index], index, dp);
        int notTake = minCoins(coins, amount, index + 1, dp);

        return dp[amount][index] = Math.min(take, notTake);
    }

    public static void main(String[] args) {
        int[] coins = {484,395,346,103,329};
        System.out.println(coinChange(coins, 4259));
    }
}
