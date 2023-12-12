package StringsAndArrays.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringWithConcatWords {

    public List<Integer> findSubstringOptimal(String s, String[] words) {

        if(words[0].length()*words.length>s.length())
            return new ArrayList<>();

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String current : words) {
            wordsMap.put(current, wordsMap.getOrDefault(current, 0)+1);
        }
        int i=0;
        int j=words[0].length()*words.length;
        List<Integer> result = new ArrayList<>();
        while (j <= s.length()) {
            String strToCheck = s.substring(i, j);
            if (isValid(strToCheck, wordsMap, words[0].length())) {
                result.add(i);
            }
            i++;
            j++;
        }
        return result;
    }

    private boolean isValid(String s, Map<String, Integer> wordsMap, int interval) {
        int i = 0;
        int j = interval;
        Map<String, Integer> wordsMapDup = new HashMap<>(wordsMap);
        while (j <= s.length()) {
            String check = s.substring(i, j);
            if (wordsMapDup.containsKey(check)) {
                if (wordsMapDup.get(check) == 1) {
                    wordsMapDup.remove(check);
                } else {
                    wordsMapDup.put(check, wordsMapDup.get(check) - 1);
                }
                i+=interval;
                j+=interval;
            } else {
                return false;
            }
        }
        if (wordsMapDup.size()==0)
            return true;
        return false;
    }

    // Working Solution But Time Limit Exceeded
    public List<Integer> findSubstring(String s, String[] words) {
        boolean[] wordsMap = new boolean[words.length];
        Set<String> concatenatedStrings = getAllConcatStrings(words, wordsMap, "", new HashSet<>());
        int i = 0, j = words[0].length() * words.length;
        List<Integer> result = new ArrayList<>();
        while (j <= s.length()) {
            if (concatenatedStrings.contains(s.substring(i, j))) {
                result.add(i);
            }
            i += 1;
            j += 1;
        }
        return result;
    }

    private Set<String> getAllConcatStrings(String[] words, boolean[] wordsMap, String currString, Set<String> result) {
        if (currString.length() == words[0].length() * words.length) {
            result.add(currString);
            return result;
        }

        for (int i = 0; i < words.length; i++) {
            if (!wordsMap[i]) {
                wordsMap[i] = true;
                currString += words[i];
                getAllConcatStrings(words, wordsMap, currString, result);
                currString = currString.substring(0, currString.length() - words[i].length());
                wordsMap[i] = false;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatWords substringWithConcatWords = new SubstringWithConcatWords();
        String[] words = { "foo", "bar" };
        System.out.println(substringWithConcatWords.findSubstring("foobarfoobar", words));
        System.out.println(substringWithConcatWords.findSubstringOptimal("foobarfoobar", words));
    }
}
