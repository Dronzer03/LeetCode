package Strings;

// LC - 1758
// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string
public class MinOperationAlternatingString {

    public static int minOperations(String s) {
        char ch0 = '0';
        char ch1 = '1';
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != ch0)
                count1++;
            if (curr != ch1)
                count2++;
            if (ch0 == '0')
                ch0 = '1';
            else
                ch0 = '0';
            if (ch1 == '1')
                ch1 = '0';
            else
                ch1 = '1';
        }
        return Math.min(count1, count2);
    }

    public static void main(String[] args) {
        System.out.println(minOperations("1111"));
    }
}
