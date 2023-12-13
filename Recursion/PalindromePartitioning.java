package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        return solve(s, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private static List<List<String>> solve(String s, List<List<String>> result, List<String> currString, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(currString));
            return result;
        }

        for (int i=index; i<s.length(); ++i) {
            String str = s.substring(index, i+1);
            if (isPalindrome(str)) {
                currString.add(str);
                solve(s, result, currString, i+1);
                currString.remove(currString.size()-1);
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        partition("efe").forEach(s -> System.out.println(s.toString()));
    }
}
