package DynamicProgramming;

public class ClimbingStairs {
    public int climbStairs(int n) {
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
}
