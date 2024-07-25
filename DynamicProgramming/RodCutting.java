package DynamicProgramming;

// Rod Cutting Problem - Coding Ninjas
// https://www.codingninjas.com/studio/problems/rod-cutting-problem_800284
// GFG
// https://www.geeksforgeeks.org/problems/rod-cutting0840/1
public class RodCutting {
    public static int cutRod(int price[], int n) {
        // Write your code here.
        Integer[][] dp = new Integer[n][n + 1];
        return maxPrice(price, n, 0, dp);
    }

    private static int maxPrice(int[] price, int n, int index, Integer[][] dp) {
        if (index == price.length) {
            if (n == 0)
                return 0;
            return Integer.MIN_VALUE;
        }

        if (dp[index][n] != null) {
            return dp[index][n];
        }

        int notTake = maxPrice(price, n, index + 1, dp);
        int take = Integer.MIN_VALUE;
        if (n >= index + 1) {
            take = price[index] + maxPrice(price, n - index - 1, index, dp);
        }

        return dp[index][n] = Math.max(take, notTake);
    }

    public int cutRodSimple(int price[], int n) {
        //code here
        Integer[][] dp = new Integer[n + 1][n + 1];
        return findMaxPrice(price, n - 1, 1, dp);
    }

    private int findMaxPrice(int[] price, int n, int currLen, Integer[][] dp) {
        if (n == 0)
            return price[currLen - 1];

        if (dp[n][currLen] != null)
            return dp[n][currLen];

        return dp[n][currLen] = Math.max(
                price[currLen - 1] + findMaxPrice(price, n - 1, 1, dp),
                findMaxPrice(price, n - 1, currLen + 1, dp)
        );
    }

    public static int cutRodTabulated(int[] price, int n) {
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * price[0];
        }

        for (int index = 1; index < n; index++) {
            for (int len = 0; len <= n; len++) {
                int notTake = dp[index - 1][len];
                int take = Integer.MIN_VALUE;
                if (index + 1 <= len) {
                    take = price[index] + dp[index][len - index - 1];
                }
                dp[index][len] = Math.max(take, notTake);
            }
        }

        return dp[n-1][n];
    }

    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10};
        System.out.println(cutRod(price, 5));
        System.out.println(cutRodTabulated(price, 5));
    }
}
