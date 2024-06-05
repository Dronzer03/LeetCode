package HashTable;

import java.util.HashMap;
import java.util.Map;

// LC - 1624
// https://leetcode.com/problems/largest-substring-between-two-equal-characters
public class LongestSubstringBwSameChars {
    public static int maxLengthBetweenEqualCharacters(String s) {
        int maxLen = -1;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                maxLen = Math.max(maxLen, (i - charMap.get(s.charAt(i)) - 1));
            } else {
                charMap.put(s.charAt(i), i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("cbzxyc"));
    }
}
