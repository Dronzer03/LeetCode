package Strings;

// LC - 1704
// https://leetcode.com/problems/determine-if-string-halves-are-alike
public class StringHalvesAlike {
    public static boolean halvesAreAlike(String s) {
        return countVowels(s.substring(0, s.length()/2)) == countVowels(s.substring(s.length()/2));
    }

    private static int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) == 'a' || Character.toLowerCase(s.charAt(i)) == 'e'
                    || Character.toLowerCase(s.charAt(i)) == 'i' || Character.toLowerCase(s.charAt(i)) == 'o'
                    || Character.toLowerCase(s.charAt(i)) == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
    }
}
