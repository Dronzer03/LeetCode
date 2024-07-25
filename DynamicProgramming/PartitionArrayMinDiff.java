package DynamicProgramming;

import java.util.Arrays;

// Gives TLE
// Not able to Memoize this
// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference
public class PartitionArrayMinDiff {
    public int sum = 0;
    public int minDiff = Integer.MAX_VALUE;
    public int minimumDifference(int[] nums) {
        sum = Arrays.stream(nums).sum();
        findMinDiff(nums, 0, 0, 0);
        return minDiff;
    }

    private void findMinDiff(int[] nums, int index, int length, int currSum) {
        if (length == nums.length/2) {
            minDiff = Math.min(minDiff, Math.abs(sum - 2 * currSum));
            return;
        }

        if (index == nums.length)
            return;

        findMinDiff(nums, index + 1, length + 1, currSum + nums[index]);
        findMinDiff(nums, index + 1, length, currSum);
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,0,4,-2,-9};
        System.out.println(new PartitionArrayMinDiff().minimumDifference(nums));
    }
}
