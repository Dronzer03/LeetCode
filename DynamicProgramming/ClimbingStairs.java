package DynamicProgramming;

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
    // Time limit exceeded on leetcode
    public int climbStairsRecursive(int n) {
        if (n <= 1)
            return 1;

        int single = climbStairsRecursive(n - 1);
        int twice = climbStairsRecursive(n - 2);
        return single + twice;
    }

    // Not an optimal solution
    // Time limit exceeded
    public static int climbStairsForward(int index, int n, int[] dp) {
        if (index == n)
            return 1;
        if (index > n)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int oneStep = climbStairsForward(index + 1, n, dp);
        int twoSteps = climbStairsForward(index + 2, n, dp);

        return dp[index] = oneStep + twoSteps;
    }

    public static void main(String[] args) {
        int[] dp = new int[45];
        for (int i=0; i<45; i++)
            dp[i] = -1;
        System.out.println(climbStairsForward(0, 45, dp));
        System.out.println(climbStairs(45));
    }
}
