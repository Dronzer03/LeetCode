package DynamicProgramming;

import java.util.Arrays;

public class FrogWithKJumps {
    public static int frogWithKJumps(int index, int k, int[] nums, int[] dp) {
        if (index == 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int result = frogWithKJumps(index - i, k, nums, dp) + Math.abs(nums[index] - nums[index - i]);
                min = Math.min(min, result);
            }
        }
        return dp[index] = min;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 20, 10};
        int n = 3;
        int k = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(frogWithKJumps(n-1, k, nums1, dp));
    }
}