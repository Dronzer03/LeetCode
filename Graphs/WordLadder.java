package Graphs;

import java.util.*;

// LC - 127
// https://leetcode.com/problems/word-ladder
public class WordLadder {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList(words)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        words.remove(beginWord);
        int ladder = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ladder++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return ladder;
                for (int index = 0; index < word.length(); index++) {
                    for (char a = 'a'; a <= 'z'; a++) {
                        char[] wordArray = word.toCharArray();
                        wordArray[index] = a;
                        String newWord = new String(wordArray);
                        if (words.contains(newWord)) {
                            queue.offer(newWord);
                            words.remove(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
