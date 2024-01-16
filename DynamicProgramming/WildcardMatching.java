package DynamicProgramming;

// LC - 44
// https://leetcode.com/problems/wildcard-matching
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length() + 1];
        return check(s, p, 0, 0, dp);
    }

    private static boolean check(String s, String p, int index1, int index2, Boolean[][] dp) {
        if (index1 == s.length()) {
            if (index2 == p.length())
                return true;
            if (p.charAt(index2) == '*')
                return check(s, p, index1, index2 + 1, dp);
            return false;
        }

        if (dp[index1][index2] != null)
            return false;

        if (index2 == p.length())
            return false;

        if (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '?') {
            return dp[index1][index2] = check(s, p, index1 + 1, index2 + 1, dp);
        }

        if (p.charAt(index2) == '*') {
            return dp[index1][index2] = check(s, p, index1 + 1, index2, dp) ||
                    check(s, p, index1, index2 + 1, dp);

        }
        return dp[index1][index2] = false;
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = "ab*";
        System.out.println(isMatch(s, p));
    }
}
