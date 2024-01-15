package DynamicProgramming;

// Coding Ninjas
// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrom
public class ConvertStringAtoB {
    public static int canYouMake(String text1, String text2) {
        // Write your code here.
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

        int deletions = text1.length() - dp[text1.length()][text2.length()];
        int insertions = text2.length() - dp[text1.length()][text2.length()];
        return insertions + deletions;
    }
}
