package DynamicProgramming;

import java.util.Arrays;

public class MaxSumNonAdjacentElements {

    // Memoization
    public static int maxSumBetter (int index, int[] arr, int[] dp) {
        if (index == 0)
            return arr[0];

        if (index < 0)
            return 0;

        if (dp[index] != -1)
            return -1;

        int two = arr[index] + maxSumBetter(index - 2, arr, dp);
        int one = maxSumBetter(index -1, arr, dp);

        return dp[index] = Math.max(one, two);
    }

    // Tabulation
    public static int maxSumOptimal (int[] arr, int[] dp) {
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int take = arr[i];
            if (i > 1)
                take += dp [i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[arr.length-1];
    }

    public static int houseRobber (int[] arr, int[] dp) {
        int[] arrFirst = new int[arr.length-1];
        int[] arrSecond = new int[arr.length-1];
        for (int i=0; i<arr.length; i++) {
            if (i!=0)
                arrSecond[i-1] = arr[i];
            if (i!=arr.length-1)
                arrFirst[i] = arr[i];
        }
        return Math.max(maxSumOptimal(arrFirst, dp), maxSumOptimal(arrSecond, dp));
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 5, 5};
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(maxSumBetter(nums.length-1, nums, dp));
        System.out.println(maxSumOptimal(nums, dp));
        System.out.println(houseRobber(nums, dp));
    }
}
