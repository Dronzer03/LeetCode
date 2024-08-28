package DynamicProgramming;

// LC - 650
// https://leetcode.com/problems/2-keys-keyboard/
public class TwoKeys {
    public int minSteps(int n) {
        if (n == 1)
            return 0;

        Integer[][] dp = new Integer[n + 1][n + 1];

        return 1 + findMinSteps(1, n, 1, dp);
    }

    private int findMinSteps(int total, int n, int last, Integer[][] dp) {
        if (total == n)
            return 0;

        if (total > n)
            return 1001;

        if (dp[total][last] != null)
            return dp[total][last];

        int pasteLast = 1 + findMinSteps(total + last, n, last, dp);
        int pasteCurrent = 2 + findMinSteps(total + last, n, total + last, dp);

        return dp[total][last] = Math.min(pasteCurrent, pasteLast);
    }

    // Prime Factors
    public int minStepsOptimal(int n) {
        int ans = 0;
        int d = 2;
        while (n > 1) {
            // If d is prime factor, keep dividing
            // n by d until is no longer divisible
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
