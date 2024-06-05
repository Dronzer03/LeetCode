package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// LC - 3
// https://leetcode.com/problems/longest-substring-without-repeating-characters
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()<=1)
            return s.length();
        int maxLen = 0;
        int start=0, end = 0;
        Set<Character> substringSet = new HashSet<>();
        while (start<s.length() && end<s.length()) {
            if (!substringSet.contains(s.charAt(end))) {
                substringSet.add(s.charAt(end));
                end++;
                if (substringSet.size() > maxLen) {
                    maxLen = substringSet.size();
                }
            } else {
                while (start <= end) {
                    substringSet.remove(s.charAt(start));
                    if (s.charAt(start)==s.charAt(end)) {
                        start++;
                        break;
                    }
                    start++;
                }
            }
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringBetterWay(String s) {
        if (s.length()<=1)
            return s.length();
        int maxLen = 0;
        int start=0, end = 0;
        Map<Character, Integer> substringMap = new HashMap<>();
        while (end<s.length()) {
            if (substringMap.containsKey(s.charAt(end))) {
                start = Math.max(substringMap.get(s.charAt(end))+1, start);
            }
            substringMap.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end-start+1);
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstringBetterWay(s));
    }
}
