package DynamicProgramming;

// GFG
// https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
// https://www.codingninjas.com/studio/problems/unbounded-knapsack_1215029
public class UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        Integer[][] dp = new Integer[n][w+1];
        return maxWeight(w, 0, profit, weight, dp);
    }

    private static int maxWeight(int maxWeight, int index, int[] profit, int[] weight, Integer[][] dp) {
        if (index == weight.length) {
            if (maxWeight == 0)
                return 0;
            return Integer.MIN_VALUE;
        }

        if (dp[index][maxWeight] != null)
            return dp[index][maxWeight];

        int notPick = maxWeight(maxWeight, index + 1, profit, weight, dp);
        int pick = Integer.MIN_VALUE;
        if (maxWeight >= weight[index])
            pick =  profit[index] + maxWeight(maxWeight - weight[index], index, profit, weight, dp);


        return dp[index][maxWeight] = pick < 0 && notPick < 0 ? 0 : Math.max(pick, notPick);
    }

    public static int unboundedKnapsackTabulation(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for (int i=weight[0]; i<=w; i++) {
            dp[0][i] = (i / weight[0]) * profit[0];
        }

        for (int index = 1; index < n; index++) {
            for (int maxWeight = 0; maxWeight <= w; maxWeight++) {
                int notPick = dp[index - 1][maxWeight];
                int pick = Integer.MIN_VALUE;
                if (weight[index] <= maxWeight) {
                    pick = profit[index] + dp[index][maxWeight - weight[index]];
                }
                dp[index][maxWeight] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][w];
    }

    public static void main(String[] args) {
//        int n = 10;
//        int maxWeight = 4;
//        int[] profit = {5,4,8,9,1,6,3,2,7,10 };
//        int[] weight = {5,6,3,4,1,2,10,7,8,9};
        int n = 3;
        int maxWeight = 15;
        int[] profit = {7,2,4};
        int[] weight = {5,10,20};
        System.out.println(unboundedKnapsack(n, maxWeight, profit, weight));
        System.out.println(unboundedKnapsackTabulation(n, maxWeight, profit, weight));
    }
}
