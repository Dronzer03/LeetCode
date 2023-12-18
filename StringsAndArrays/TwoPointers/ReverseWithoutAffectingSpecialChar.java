package StringsAndArrays.TwoPointers;

import java.util.Arrays;

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

    public static void main(String[] args) {
        System.out.println(reverse("A&B#"));
    }
}
