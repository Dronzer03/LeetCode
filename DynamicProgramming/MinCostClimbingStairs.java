package DynamicProgramming;

// LC - 746
// https://leetcode.com/problems/min-cost-climbing-stairs
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp1 = new Integer[cost.length];
        Integer[] dp2 = new Integer[cost.length];
        return Math.min(findMinCost(0, cost, dp1), findMinCost(1, cost, dp2));
    }

    private int findMinCost(int index, int[] cost, Integer[] dp) {
        if (index >= cost.length)
            return 0;

        if (dp[index] != null)
            return dp[index];

        return dp[index] = cost[index] + Math.min(findMinCost(index + 1, cost, dp), findMinCost(index + 2, cost, dp));
    }

    public int minCostTabulation(int[] cost) {
        int n = cost.length;
        int one = 0;
        int two = 0;
        for (int index = 2; index <= n; index++) {
            int temp = Math.min(one + cost[index - 1], two + cost[index - 2]);
            two = one;
            one = temp;
        }

        return two;
    }
}
