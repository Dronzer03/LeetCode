package DynamicProgramming;

public class DistinctSubSequences {
    public static int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()+1];
        return distinctOccurances(s, t, 0, 0, dp);
    }

    private static int distinctOccurances(String s, String t, int index1, int index2, Integer[][] dp) {
        if (index1 == s.length()) {
            if (index2 == t.length())
                return 1;
            return 0;
        }

        if (dp[index1][index2] != null)
            return dp[index1][index2];

        int match = 0;
        if (index2 < t.length() && s.charAt(index1) == t.charAt(index2)) {
            match = distinctOccurances(s, t, index1 + 1, index2 + 1, dp);
        }
        int skip = distinctOccurances(s, t, index1 + 1, index2, dp);

        return dp[index1][index2] = match + skip;
    }

    public static int numDistinctTabulated(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i=0; i<=s.length(); i++)
            dp[i][0] = 1;

        for (int index1 = 1; index1 <= s.length(); index1++) {
            for (int index2 = 1; index2 <= t.length(); index2++) {
                if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1] + dp[index1 - 1][index2];
                } else {
                    dp[index1][index2] = dp[index1 - 1][index2];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }
}
