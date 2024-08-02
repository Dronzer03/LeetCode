package SlidingWindow;

// LC - 2134
// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
public class MinSwaps {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for (int n : nums)
            if (n == 1)
                ones++;

        int end = 0;
        int count = nums[0];
        int minSwaps = Integer.MAX_VALUE;
        for (int start = 0; start < nums.length; start++) {
            if (start != 0)
                count -= nums[start - 1];

            while (end - start + 1 < ones) {
                end++;
                count += nums[end % nums.length];
            }

            minSwaps = Math.min(minSwaps, ones - count);
        }

        return minSwaps;
    }
}
