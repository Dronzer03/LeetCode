package Recursion;

import java.util.ArrayList;
import java.util.List;

// LC - 17
// https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return findCombinations(digits, keys, new ArrayList<>(), "", 0);
    }

    private static List<String> findCombinations(String digits, String[] keys, List<String> result, String currString, int index) {
        if (index == digits.length()) {
            result.add(currString);
            return result;
        }

        char ch = digits.charAt(index);
        String options = keys[Character.getNumericValue(ch)];

        for (int i = 0; i < options.length(); i++) {
            result = findCombinations(digits, keys, result, currString + options.charAt(i), index + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }
}
