package DynamicProgramming;

// LC - 647
// https://leetcode.com/problems/palindromic-substrings
public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        if (s.length() == 1)
            return 1;

        int result = 0;
        for (int index = 0; index < s.length() - 1; index++) {
            result += findSubstringsWithMiddle(s, index, index, 0);
            result += findSubstringsWithMiddle(s, index, index + 1, 0);
        }
        return result + 1;
    }

    private static int findSubstringsWithMiddle(String s, int left, int right, int count) {
        if (left < 0 || right == s.length())
            return count;

        return s.charAt(left) == s.charAt(right) ?
                findSubstringsWithMiddle(s, left - 1, right + 1, count + 1) : count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }
}
