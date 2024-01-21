package DynamicProgramming;

public class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return countWays(nums, target, dp);
    }

    public static int countWays(int[] nums, int target, Integer[] dp) {
        if (target == 0)
            return 1;

        if (dp[target] != null)
            return dp[target];

        int ways = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                ways += combinationSum4(nums, target - nums[i]);
        }
        return dp[target] = ways;
    }

    public static int combinationSum4Tabulated(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
