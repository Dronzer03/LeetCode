package HashSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LC - 648
// https://leetcode.com/problems/replace-words
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for (int index = 0; index < words.length; index++) {
            words[index] = findRoot(words[index], dict);
        }
        return String.join(" ", words);
    }

    private String findRoot(String word, Set<String> dict) {
        for (int index = 1; index <= word.length(); index++) {
            String prefix = word.substring(0, index);
            if (dict.contains(prefix))
                return prefix;
        }
        return word;
    }
}
