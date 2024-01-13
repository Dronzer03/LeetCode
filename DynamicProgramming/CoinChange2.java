package DynamicProgramming;

// LC - 518
// https://leetcode.com/problems/coin-change-ii
public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return findWays(coins, amount, 0, dp);
    }

    private static int findWays(int[] coins, int amount, int index, Integer[][] dp) {
        if (index == coins.length) {
            if (amount == 0)
                return 1;
            return 0;
        }

        if (amount < 0)
            return 0;

        if (dp[index][amount] != null)
            return dp[index][amount];

        int pick = findWays(coins, amount - coins[index], index, dp);
        int notPick = findWays(coins, amount, index + 1, dp);

        return dp[index][amount] = pick + notPick;
    }

    public static int changeTabulation(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i=0; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        for (int index = 1; index < coins.length; index++) {
            for (int target = 0; target <= amount; target++) {
                int take = 0;
                if (target >= coins[index])
                    take = dp[index][target - coins[index]];
                dp[index][target] = take + dp[index-1][target];
            }
        }

        return dp[coins.length-1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(change(5, coins));
        System.out.println(changeTabulation(5, coins));
    }
}
