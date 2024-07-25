package DynamicProgramming;

// GFG
// https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
// https://www.codingninjas.com/studio/problems/0-1-knapsack_920542
public class Knapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        Integer[][] dp = new Integer[n][maxWeight+1];
        return maxSteal(weight, value, maxWeight, 0, dp);
    }

    private static int maxSteal(int[] weight, int[] value, int maxWeight, int index, Integer[][] dp) {
        if (index == weight.length)
            return 0;

        if (dp[index][maxWeight] != null)
            return dp[index][maxWeight];

        int notPick = maxSteal(weight, value, maxWeight, index + 1, dp);
        int pick = 0;
        if (weight[index] <= maxWeight) {
            pick = value[index] + maxSteal(weight, value, maxWeight - weight[index], index + 1, dp);
        }

        return dp[index][maxWeight] = Math.max(pick, notPick);
    }
}
