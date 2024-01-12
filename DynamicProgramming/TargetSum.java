package DynamicProgramming;

import java.util.Arrays;

// LC - 494
// https://leetcode.com/problems/target-sum
public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum - target < 0 || (sum - target) % 2 == 1) {
            return 0;
        }
        Integer[][] dp = new Integer[nums.length][((sum - target) / 2) + 1];
        return findWays(nums, (sum - target) / 2, 0, dp);
    }

    private static int findWays(int[] nums, int target, int index, Integer[][] dp) {
        if (index == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[index][target] != null)
            return dp[index][target];

        int notPick = findWays(nums, target, index + 1, dp);
        int pick = 0;
        if (nums[index] <= target) {
            pick = findWays(nums, target - nums[index], index + 1, dp);
        }

        return dp[index][target] = pick + notPick;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }
}
