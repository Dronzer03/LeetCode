package StringsAndArrays.HashTable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        int length = pattern.length();
        String[] words = s.split(" ");

        if (length != words.length)
            return false;

        Map<Character, String> wordsMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (wordsMap.containsKey(ch)) {
                if (!wordsMap.get(ch).equals(word))
                    return false;
            } else {
                if (wordsMap.containsValue(word))
                    return false;
                wordsMap.put(pattern.charAt(i), word);
            }
        }

        return true;
    }
}
