package DynamicProgramming;

// LC - 91
// https://leetcode.com/problems/decode-ways
public class DecodingWays {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0')
            return 0;
        return decode(0, s);
    }

    private int decode(int index, String s) {
        if (index == s.length())
            return 1;

        if (s.charAt(index) == '0')
            return 0;

        int result = decode(index + 1, s);

        if (index < s.length() - 1 && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {
            result += decode(index + 2, s);
        }

        return result;
    }

    public static int numDecodingsDp(String s) {
        if (s.isEmpty() || s.charAt(0) == '0')
            return 0;
        Integer[] dp = new Integer[s.length()];
        return decodeDp(0, dp, s);
    }

    private static int decodeDp(int index, Integer[] dp, String s) {
        if (index == s.length())
            return 1;

        if (s.charAt(index) == '0')
            return 0;

        if (dp[index] != null)
            return dp[index];

        int result = decodeDp(index + 1, dp, s);

        if (index < s.length() - 1 && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {
            result += decodeDp(index + 2, dp, s);
        }

        return dp[index] = result;
    }

    public static void main(String[] args) {
        System.out.println(numDecodingsDp("226"));
    }
}
