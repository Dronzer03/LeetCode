package DynamicProgramming;

public class HouseRobber {
    public static int rob(int[] nums) {
        return maxRob(0, nums);
    }

    private static int maxRob(int index, int[] nums) {
        if (index >= nums.length)
            return 0;

        int take = nums[index] + maxRob(index+2, nums);
        int notTake = maxRob(index+1, nums);

        return Math.max(take, notTake);
    }

    public static int robDp(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return maxRobDp(nums, dp,0);
    }

    private static int maxRobDp(int[] nums, Integer[] dp, int index) {
        if (index >= nums.length)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int take = nums[index] + maxRobDp(nums, dp, index + 2);
        int notTake = maxRobDp(nums, dp, index + 1);

        return dp[index] = Math.max(take, notTake);
    }

    public static int robOptimised (int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i=1; i<nums.length; i++) {
            int take = nums[i];
            if (i > 1)
                take += dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
        System.out.println(robDp(nums));
        System.out.println(robOptimised(nums));
    }
}
