package DynamicProgramming;

// LC - 583
// https://leetcode.com/problems/delete-operation-for-two-strings
public class DeleteOperationsForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int index1 = 1; index1 <= word1.length(); index1++) {
            for (int index2 = 1; index2 <= word2.length(); index2++) {
                if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                }
                dp[index1][index2] = Math.max(dp[index1][index2],
                        Math.max(
                                dp[index1 - 1][index2], dp[index1][index2 - 1]
                        ));
            }
        }

        return word1.length() + word2.length() - (2 * dp[word1.length()][word2.length()]);
    }
}
