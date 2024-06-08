package Strings;

// LC - 3174
// https://leetcode.com/problems/clear-digits
public class ClearDigits {
    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                result.append(ch);
            } else {
                result.deleteCharAt(result.length() - 1);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ClearDigits().clearDigits("abc"));
    }
}
