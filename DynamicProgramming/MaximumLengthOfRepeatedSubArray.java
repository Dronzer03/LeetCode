package DynamicProgramming;

public class MaximumLengthOfRepeatedSubArray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;

        for (int index1 = 1; index1 <= nums1.length; index1++) {
            for (int index2 = 1; index2 <= nums2.length; index2++) {
                if (nums1[index1 - 1] == nums2[index2 - 1]) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                    max = Math.max(max, dp[index1][index2]);
                } else {
                    dp[index1][index2] = 0;
                }
            }
        }

        return max;
    }
}
