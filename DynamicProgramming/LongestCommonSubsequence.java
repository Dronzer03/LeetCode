package DynamicProgramming;

// LC - 1143
// https://leetcode.com/problems/longest-common-subsequence
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return longestCommon(text1, text2, 0, 0, dp);
    }

    private static int longestCommon(String text1, String text2, int index1, int index2, Integer[][] dp) {
        if (index1 == text1.length() || index2 == text2.length())
            return 0;

        if (dp[index1][index2] != null)
            return dp[index1][index2];

        int match = 0;
        if (text1.charAt(index1) == text2.charAt(index2)) {
            match = 1 + longestCommon(text1, text2, index1 + 1, index2 + 1, dp);
        }

        int moveFirst = longestCommon(text1, text2, index1 + 1, index2, dp);
        int moveSecond = longestCommon(text1, text2, index1, index2 + 1, dp);

        return dp[index1][index2] = Math.max(match, Math.max(moveFirst, moveSecond));
    }

    public static int LCSTabulated(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int index1 = 1; index1 <= text1.length(); index1++) {
            for (int index2 = 1; index2 <= text2.length(); index2++) {
                int match = 0;
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    match = 1 + dp[index1 - 1][index2 - 1];
                }
                int moveFirst = dp[index1 - 1][index2];
                int moveSecond = dp[index1][index2 - 1];

                dp[index1][index2] = Math.max(match, Math.max(moveFirst, moveSecond));
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
