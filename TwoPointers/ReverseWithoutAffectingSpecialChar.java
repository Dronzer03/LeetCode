package TwoPointers;

import java.util.Arrays;

// LC - 917
// https://leetcode.com/problems/reverse-only-letters
public class ReverseWithoutAffectingSpecialChar {
    public static String reverse(String str)
    {
        //complete the function here
        char[] strArray = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while (left < right) {
            // Noice
            if (!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
                continue;
            }
            char ch = strArray[left];
            strArray[left] = strArray[right];
            strArray[right] = ch;
            left++;
            right--;
        }
        return new String(strArray);
    }

    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;

        char[] res = new char[s.length()];

        while (left <= right) {
            if (!Character.isLetter(s.charAt(left))) {
                res[left] = s.charAt(left);
                left++;
                continue;
            }

            if (!Character.isLetter(s.charAt(right))) {
                res[right] = s.charAt(right);
                right--;
                continue;
            }

            res[left] = s.charAt(right);
            res[right] = s.charAt(left);
            left++;
            right--;
        }

        return Arrays.toString(res);
    }

    public static void main(String[] args) {
        System.out.println(reverse("A&B#"));
    }
}
