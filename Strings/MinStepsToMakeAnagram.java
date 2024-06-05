package Strings;

import java.util.HashMap;
import java.util.Map;

// LC - 1347
// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
public class MinStepsToMakeAnagram {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i) , 0) + 1);
        }
        int steps = 0;
        for (int i=0; i < t.length(); i++) {
            if (sMap.containsKey(t.charAt(i))) {
                if (sMap.get(t.charAt(i)) == 1)
                    sMap.remove(t.charAt(i));
                else
                    sMap.put(t.charAt(i), sMap.get(t.charAt(i)) - 1);
            } else
                steps++;
        }
        return steps;
    }
}
