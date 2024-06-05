package HashTable;

import java.util.HashMap;
import java.util.Map;

// LC - 1897
// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal
public class RedistributeCharacters {
    public static boolean makeEqual(String[] words) {
        if (words.length == 1)
            return true;
        Map<Character, Integer> characterMap = new HashMap<>();
        int charCount = 0;
        for (String current : words) {
            charCount += current.length();
            for (int i = 0; i < current.length(); i++) {
                characterMap.put(current.charAt(i), characterMap.getOrDefault(current.charAt(i), 0) + 1);
            }
        }
        int len = words.length;
        if (charCount % len != 0)
            return false;

        for (Integer value : characterMap.values()) {
            if (value % len != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "aabc", "bc"};
        System.out.println(makeEqual(words));
    }
}
