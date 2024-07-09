package DynamicProgramming;

import java.util.Arrays;

// LC - 213
// https://leetcode.com/problems/house-robber-ii
public class HouseRobber2 {
    private static int maxRobDp(int[] nums, Integer[] dp, int index) {
        if (index >= nums.length)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int take = nums[index] + maxRobDp(nums, dp, index + 2);
        int notTake = maxRobDp(nums, dp, index + 1);

        return dp[index] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new HouseRobber2().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Integer[] dp1 = new Integer[nums.length];
        Integer[] dp2 = new Integer[nums.length];
        int[] start = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] end = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(
                maxRobDp(start, dp1, 0),
                maxRobDp(end, dp2, 0)
        );
    }
}
