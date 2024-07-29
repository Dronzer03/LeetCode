package DynamicProgramming;

// LC - 1035
// https://leetcode.com/problems/uncrossed-lines
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int index1 = 1; index1 <= nums1.length; index1++) {
            for (int index2 = 1; index2 <= nums2.length; index2++) {
                if (nums1[index1 - 1] == nums2[index2 - 1]) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                }
                dp[index1][index2] = Math.max(dp[index1][index2],
                        Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]));
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
