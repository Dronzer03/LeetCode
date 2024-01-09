package DynamicProgramming;

import java.util.Arrays;

// LC - 416
// https://leetcode.com/problems/partition-equal-subset-sum
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[nums.length][(sum / 2) + 1];
        return checkSubSet(nums, 0, sum / 2, dp);
    }

    private static boolean checkSubSet(int[] arr, int index, int target, Boolean[][] dp) {
        if (target == 0)
            return true;

        if (index == arr.length || target < 0)
            return false;

        if (dp[index][target] != null)
            return dp[index][target];

        //take
        if (checkSubSet(arr, index + 1, target - arr[index], dp) || checkSubSet(arr, index + 1, target, dp))
            return true;

        return dp[index][target] = false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
    }
}
