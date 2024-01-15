package DynamicProgramming;

// LC - 1092
// https://leetcode.com/problems/shortest-common-supersequence
public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int index1 = 1; index1 <= str1.length(); index1++) {
            for (int index2 = 1; index2 <= str2.length(); index2++) {
                if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        int index1 = str1.length();
        int index2 = str2.length();

        StringBuilder str = new StringBuilder();
        while (index1 > 0 && index2 > 0) {
            if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
                str.append(str1.charAt(index1 - 1));
                index1--;
                index2--;
            } else if (dp[index1 - 1][index2] > dp[index1][index2 - 1]) {
                str.append(str1.charAt(index1 - 1));
                index1--;
            } else {
                str.append(str2.charAt(index2 - 1));
                index2--;
            }
        }
        while (index1 > 0) {
            str.append(str1.charAt(--index1));
        }

        while (index2 > 0) {
            str.append(str2.charAt(--index2));
        }

        return new String(str.reverse());
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }
}
