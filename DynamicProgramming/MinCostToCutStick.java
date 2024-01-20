package DynamicProgramming;

import java.util.Arrays;

public class MinCostToCutStick {
    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        int index = 1;
        for (int cut : cuts) {
            newCuts[index++] = cut;
        }
        newCuts[index] = n;
        Integer[][] dp = new Integer[newCuts.length][newCuts.length];
        return findMinCost(newCuts, 1, cuts.length, dp);
    }

    private static int findMinCost(int[] newCuts, int i, int j, Integer[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int index = i; index <= j; index++) {
            int cost = newCuts[j + 1] - newCuts[i - 1] +
                    findMinCost(newCuts, i, index - 1, dp) + findMinCost(newCuts, index + 1, j, dp);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }

    public static void main(String[] args) {
        int[] cuts = {1,3,4,5};
        System.out.println(minCost(7, cuts));
    }
}
