package TwoPointers;

// LC - 125
// https://leetcode.com/problems/valid-palindrome
public class Palindrome {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]","");
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            Character atStart = Character.toLowerCase(s.charAt(start));
            Character atEnd = Character.toLowerCase(s.charAt(end));
            
            if (atStart != atEnd)
                return false;

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

}
