package DynamicProgramming;

// LC - 72
// https://leetcode.com/problems/edit-distance
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length() + 1];
        return findMinDistance(word1, word2, 0, 0, dp);
    }

    private static int findMinDistance(String word1, String word2, int index1, int index2, Integer[][] dp) {
        if (index2 == word2.length()) {
            if (index1 == word1.length())
                return 0;
            return word1.length() - index1;
        }

        if (index1 == word1.length()) {
            return word2.length() - index2;
        }

        if (dp[index1][index2] != null)
            return dp[index1][index2];

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return dp[index1][index2] = findMinDistance(word1, word2, index1 + 1, index2 + 1, dp);
        } else {
            int deletion = 1 + findMinDistance(word1, word2, index1 + 1, index2, dp);
            int insertion = 1 + findMinDistance(word1, word2, index1, index2 + 1, dp);
            int replace = 1 + findMinDistance(word1, word2, index1 + 1, index2 + 1, dp);

            return dp[index1][index2] = Math.min(deletion, Math.min(insertion, replace));
        }
    }

    public static int minDistanceTabulated(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;

        for (int j = 0; j <= word2.length(); j++)
            dp[0][j] = j;

        for (int index1 = 1; index1 <= word1.length(); index1++) {
            for (int index2 = 1; index2 <= word2.length(); index2++) {
                if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = 1 + Math.min(
                            dp[index1 - 1][index2], Math.min(
                                    dp[index1][index2 - 1], dp[index1 - 1][index2 - 1]
                            )
                    );

                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistanceTabulated("horse", "ros"));
    }
}
