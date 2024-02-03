package DynamicProgramming;

// LC - 1043
// https://leetcode.com/problems/partition-array-for-maximum-sum
public class MaxSumPartitionArray {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] dp = new Integer[arr.length];
        return maxSumPartitions(arr, k, 0, dp);
    }

    private static int maxSumPartitions(int[] arr, int k, int index, Integer[] dp) {
        if (index >= arr.length)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int max = Integer.MIN_VALUE;
        int res = 0;

        for (int j = index; j < Math.min(arr.length, index + k); j++) {
            max = Math.max(max, arr[j]);
            int windowSize = j - index + 1;
            res = Math.max(res, windowSize * max + maxSumPartitions(arr, k, j + 1, dp));
        }

        return dp[index] = res;
    }

    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        System.out.println(maxSumAfterPartitioning(arr, 3));
    }
}
