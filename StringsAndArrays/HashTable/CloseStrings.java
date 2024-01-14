package StringsAndArrays.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LC - 1657
// https://leetcode.com/problems/determine-if-two-strings-are-close
public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            word1Map.put(word1.charAt(i), word1Map.getOrDefault(word1.charAt(i), 0) + 1);
            word2Map.put(word2.charAt(i), word2Map.getOrDefault(word2.charAt(i), 0) + 1);
        }

        List<Integer> map1Values = new ArrayList<>(word1Map.values());

        for (Map.Entry<Character, Integer> entry : word2Map.entrySet()) {
            if (word1Map.containsKey(entry.getKey())) {
                if (map1Values.contains(entry.getValue())) {
                    map1Values.remove(entry.getValue());
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
