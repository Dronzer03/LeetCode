package DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LC -139
// https://leetcode.com/problems/word-break
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;

        return findWords(0, s, wordDict);
    }

    private static boolean findWords(int index, String s, List<String> wordDict) {
        if (index == s.length()) {
            return true;
        }


        for (int i = 1; i + index <= s.length(); i++) {
            String sub = s.substring(index, index + i);
            if (wordDict.contains(sub)) {
                if (findWords(index + i, s, wordDict))
                    return true;
            }
        }

        return false;
    }

    // Using Memoization
    public static boolean wordBreakDp(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        Set<String> wordSet = new HashSet<>(wordDict);
        return findWordsDp(0, s, wordSet, dp);
    }

    private static boolean findWordsDp(int index, String s, Set<String> wordDict, Boolean[] dp) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != null && !dp[index])
            return false;

        for (int i = 1; i + index <= s.length(); i++) {
            String sub = s.substring(index, index + i);
            if (wordDict.contains(sub)) {
                if (findWordsDp(index + i, s, wordDict, dp))
                    return true;
            }
        }

        return dp[index] = false;
    }

    // Another way to solve is to check every string in dict one by one if it exists in Original String
    // Thanks

    public static void main(String[] args) {
        String s = "catsandog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(wordBreak(s, List.of(wordDict)));
        System.out.println(wordBreakDp(s, List.of(wordDict)));
    }
}
