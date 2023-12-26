package DynamicProgramming;

// LC - 1155
// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum
public class RollsToTarget {
    private static int mod = (int)Math.pow(10, 9) + 7;

    // Recursive Solution
    // Doesn't work for higher numbers
    public static int numRollsToTarget(int n, int k, int target) {
        return findNumRolls(n, k, target, 0);
    }

    private static int findNumRolls(int n, int k, int target, int result) {
        if (n == 0) {
            if (target == 0)
                return result + 1;
            else
                return result;
        }

        for (int i = 1; i <= k; i++) {
            result = findNumRolls(n - 1, k, target - i, result);
        }

        return result;
    }

    public static int numRollsToTargetDp(int n, int k, int target) {
        Integer[][] dp = new Integer[n + 1][target + 1];
        return findNumRollsDp(n, k, target, dp);
    }

    private static int findNumRollsDp(int n, int k, int target, Integer[][] dp) {
        if (n == 0 && target == 0)
            return 1;

        if (n==0 || target < 0)
            return 0;

        if (dp[n][target] != null)
            return dp[n][target];

        int result = 0;

        for (int i = 1; i <= k; i++) {
             result = (result + findNumRollsDp(n-1, k, target - i, dp)) % mod;
        }
        return dp[n][target] = result;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(3, 6, 7));
        System.out.println(numRollsToTargetDp(3, 6, 7));
        System.out.println(numRollsToTargetDp(30, 30, 500));
    }
}
