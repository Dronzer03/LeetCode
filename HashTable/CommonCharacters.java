package HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonCharacters {
    public List<String> commonChars(String[] words) {
        if (words.length == 1)
            return Collections.singletonList(words[0]);

        int[] finalCount = new int[26];
        for (char ch : words[0].toCharArray()) {
            finalCount[ch - 'a']++;
        }

        for (int index = 1; index < words.length; index++) {
            int[] current = new int[26];
            for (char ch : words[index].toCharArray()) {
                current[ch - 'a']++;
            }

            for (int i=0; i < 26; i++) {
                finalCount[i] = Math.min(finalCount[i], current[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int index = 0; index < 26; index++) {
            if (finalCount[index] > 0) {
                for (int counter = finalCount[index]; counter > 0; counter--) {
                    result.add("" + (char)('a' + index));
                }
            }
        }

        return result;
    }
}
