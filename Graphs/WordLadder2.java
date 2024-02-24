package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// Working but TLE
// LC - 126
// https://leetcode.com/problems/word-ladder-ii
public class WordLadder2 {
    int minLen = (int) 1e9;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        List<List<String>> result = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        currentList.add(beginWord);
        dfs(beginWord, currentList, words, result, endWord);
        result = result.stream().filter(list -> list.size()==minLen).collect(Collectors.toList());
        return result;
    }

    private void dfs(String word, List<String> currentList, HashSet<String> words, List<List<String>> result, String endWord) {
        if (word.equals(endWord)) {
            if (currentList.size() > minLen)
                return;
            minLen = Math.min(minLen, currentList.size());
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int index = 0; index < word.length(); index++) {
            for (char a = 'a'; a <= 'z'; a++) {
                char[] wordArray = word.toCharArray();
                wordArray[index] = a;
                String newWord = new String(wordArray);
                if (words.contains(newWord) && currentList.size() < minLen) {
                    words.remove(newWord);
                    currentList.add(newWord);
                    dfs(newWord, currentList, words, result, endWord);
                    words.add(newWord);
                    currentList.remove(currentList.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(new WordLadder2().findLadders("hit", "cog", Arrays.asList(words)));
    }
}
