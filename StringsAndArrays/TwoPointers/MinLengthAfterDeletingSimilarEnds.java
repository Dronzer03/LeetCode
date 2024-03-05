package StringsAndArrays.TwoPointers;

// LC - 1750
// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends
public class MinLengthAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                while (s.charAt(left) == s.charAt(left - 1) && left < right)
                    left++;
                while (s.charAt(right) == s.charAt(right + 1) && right >= left)
                    right--;
            } else {
                break;
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new MinLengthAfterDeletingSimilarEnds().minimumLength("aaaaaaaaaaaaa"));
    }
}
