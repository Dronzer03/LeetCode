package DynamicProgramming;

// GFG
// https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
// Coding Ninjas
// https://www.codingninjas.com/studio/problems/longest-common-substring_1235207
public class LongestCommonSubstring {
    public static int LCSTabulated(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int max = 0;
        for (int index1 = 1; index1 <= text1.length(); index1++) {
            for (int index2 = 1; index2 <= text2.length(); index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
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
