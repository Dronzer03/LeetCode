package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    // Gives TLE
    public static int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparing(s -> s.length()));
        return longestChain(words, 0, "", dp);
    }

    private static int longestChain(String[] words, int index, String prev, Map<String, Integer> dp) {
        if (index == words.length)
            return 0;

        if (dp.containsKey((index + "$" + prev)))
            return dp.get(index + "$" + prev);

        int take = 0;
        if (prev.equals("") || checkPossible(words[index], prev)) {
            take = 1 + longestChain(words, index + 1, words[index], dp);
        }
        int result = Math.max(take, longestChain(words, index + 1, prev, dp));
        dp.put(index + "$" + prev, result);
        return result;
    }

    private static boolean checkPossible(String word, String prev) {
        if (word.length() != prev.length() + 1)
            return false;

        int first = 0;
        int second = 0;

        while (first < word.length()) {
            if (second < prev.length() && word.charAt(first) == prev.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == word.length() && second == prev.length();
    }

    public static int longestStrChainTabulated(String[] words) {
        int max = 0;
        int[] dp = new int[words.length];
        Arrays.sort(words, Comparator.comparing(s -> s.length()));
        Arrays.fill(dp, 1);

        for (int index = 0; index < words.length; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (checkPossible(words[index], words[prev]) && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                }
            }
            if (dp[index] > max)
                max = dp[index];
        }

        return max;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
        System.out.println(longestStrChainTabulated(words));
    }
}
