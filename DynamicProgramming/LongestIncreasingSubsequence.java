package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return longestSequence(nums, 0, -1, dp);
    }

    private static int longestSequence(int[] nums, int index, int lastIndex, Integer[][] dp) {
        if (index == nums.length)
            return 0;

        if (lastIndex>=0 && dp[index][lastIndex+1] != null)
            return dp[index][lastIndex+1];

        int take = 0;
        if (lastIndex==-1 || nums[index] > nums[lastIndex]) {
            take = 1 + longestSequence(nums, index + 1, index, dp);
        }

        int notTake = longestSequence(nums, index + 1, lastIndex, dp);

        return dp[index][lastIndex+1] = Math.max(take, notTake);
    }

    public int longestIncreasingSubsequenceDiffK(int[] arr, int k) {
        Map<Integer, Integer> dp = new HashMap<>();

        int max = 0;
        for (int n : arr) {
            dp.put(n, dp.getOrDefault(n - k, 0) + 1);
            max = Math.max(max, dp.get(n));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(nums));
    }
}
