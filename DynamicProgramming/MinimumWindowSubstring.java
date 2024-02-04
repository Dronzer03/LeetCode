package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int left = 0;
        int right = 0;
        String minSubstring = new String(s + "Test");

        Map<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        Map<Character, Integer> sMap = new HashMap<>();

        // ADOBECODEBANC
        while (left < s.length() && right < s.length()) {
            char charAtRight = s.charAt(right);
            if (tMap.containsKey(charAtRight)) {
                sMap.put(charAtRight, sMap.getOrDefault(charAtRight, 0) + 1);
            }

            if (checkStrings(sMap, tMap)) {
                while (left <s.length() && checkValidString(sMap, tMap, s.charAt(left)))
                    left++;
                String currString = s.substring(left, right + 1);
                if (currString.length() < minSubstring.length())
                    minSubstring = currString;

                if (left < s.length()) {
                    int count = sMap.get(s.charAt(left));
                    if (count == 1) {
                        sMap.remove(s.charAt(left));
                    } else {
                        sMap.put(s.charAt(left), --count);
                    }
                    left++;
                }
            }

            right++;
        }

        return minSubstring.equals(s + "Test") ? "" : minSubstring;
    }

    private static boolean checkValidString(Map<Character, Integer> sMap, Map<Character, Integer> tMap, char c) {
        if (tMap.containsKey(c)) {
            if (sMap.containsKey(c)) {
                int count = sMap.get(c);
                if (count == 1)
                    return false;

                sMap.put(c, --count);
                if (checkStrings(sMap, tMap))
                    return true;
                else {
                    sMap.put(c, ++count);
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkStrings(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        if (sMap.equals(tMap))
            return true;

        if (sMap.size() != tMap.size())
            return false;

        for (char c : tMap.keySet()) {
            if (tMap.get(c) > sMap.get(c))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "cba";
        System.out.println(minWindow(s, t));
    }
}
