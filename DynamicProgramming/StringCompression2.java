package DynamicProgramming;

public class StringCompression2 {
    public static int getLengthOfOptimalCompression(String s, int k) {
        return findCount(0, k, s, ' ', 0);
    }

    private static int findCount(int index, int k, String s, char prev, int prevCount) {
        if (k < 0)
            return Integer.MAX_VALUE;

        if (index == s.length())
            return 0;

        int res = 0;
        if (s.charAt(index) == prev) {
            int increment = 0;
            if (prevCount == 1 || prevCount == 9 || prevCount == 99)
                increment = 1;
            res = increment + findCount(index+1, k, s, s.charAt(index), prevCount+1);
        } else {
            res = Math.min(
                    findCount(index + 1, k - 1, s, prev, prevCount),
                    1 +findCount(index + 1, k, s, s.charAt(index), 1)
            );
        }
        return res;
    }

    public static int getLengthOfOptimalCompressionDp(String s, int k) {
        Integer[][][][] dp = new Integer[s.length()+1][s.length()+1][s.length()+1][32];
        return findCountDp(0, k, s, (char)('a'+26), 0, dp);
    }

    private static int findCountDp(int index, int k, String s, char prev, int prevCount, Integer[][][][] dp) {
        if (k < 0)
            return Integer.MAX_VALUE;

        if (index == s.length())
            return 0;

        if (dp[index][k][prevCount][prev-'a'] != null)
            return dp[index][k][prevCount][prev-'a'];

        int res = 0;
        if (s.charAt(index) == prev) {
            int increment = 0;
            if (prevCount == 1 || prevCount == 9 || prevCount == 99)
                increment = 1;
            res = increment + findCountDp(index+1, k, s, s.charAt(index), prevCount+1, dp);
        } else {
            res = Math.min(
                    findCountDp(index + 1, k - 1, s, prev, prevCount, dp),
                    1 +findCountDp(index + 1, k, s, s.charAt(index), 1, dp)
            );
        }
        return dp[index][k][prevCount][prev-'a'] = res;
    }

    public static void main(String[] args) {
        String s = "aabbaa";
        int k = 2;
        System.out.println(getLengthOfOptimalCompressionDp(s, k));
    }
}
