package DynamicProgramming;

// LC - 70
// https://leetcode.com/problems/climbing-stairs
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        int prev2 = 1;
        int prev1 = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }

    // This is not an optimal solution
    // Time limit exceeded on leetcode for recursive
    // Memoization beats 100%
    public static int climbStairsMemo(int n) {
        Integer[] dp = new Integer[n];
        return distinctWays(0, n, dp);
    }

    private static int distinctWays(int index, int n, Integer[] dp) {
        if (index == n)
            return 1;

        if (index > n)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int oneStep = distinctWays(index + 1, n, dp);
        int twoStep = distinctWays(index + 2, n, dp);

        return dp[index] = oneStep + twoStep;
    }

    public static void main(String[] args) {
        System.out.println(climbStairsMemo(45));
        System.out.println(climbStairs(45));
    }
}
