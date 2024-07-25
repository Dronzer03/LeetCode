package DynamicProgramming;

import java.util.Arrays;

// LC - 494
// https://leetcode.com/problems/target-sum
public class TargetSum {

    public int sum = 0;
    public int tar = 0;

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

    public int findTargetSumWaysIntuitive(int[] nums, int target) {
        sum = Arrays.stream(nums).sum();
        tar = target;
        Integer[][] dp = new Integer[nums.length][sum + 1];
        return targetWays(nums, 0, 0, dp);
    }

    private int targetWays(int[] nums, int index, int currSum, Integer[][] dp) {
        if (index == nums.length) {
            if (sum - 2 * currSum == tar)
                return 1;
            return 0;
        }

        if (dp[index][currSum] != null)
            return dp[index][currSum];

        return dp[index][currSum] = targetWays(nums, index + 1, currSum, dp)
                + targetWays(nums, index + 1, currSum + nums[index], dp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }

}