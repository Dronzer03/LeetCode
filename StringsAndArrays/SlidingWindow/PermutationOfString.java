package StringsAndArrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// LC - 567
// https://leetcode.com/problems/permutation-in-string
public class PermutationOfString {
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (int i=0; i<s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i=0; i<s2.length(); i++) {
            if (i < s1.length()) {
                s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
            } else {
                if (s1Map.equals(s2Map))
                    return true;
                char key = s2.charAt(i - s1.length());
                int count = s2Map.get(key) - 1;
                if (count == 0)
                    s2Map.remove(key);
                else
                    s2Map.put(key, count);
                s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
            }
        }

        return s1Map.equals(s2Map);
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
