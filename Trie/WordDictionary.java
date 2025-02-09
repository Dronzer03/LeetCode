package Trie;

import java.util.HashMap;
import java.util.Map;

/*
    Implement the WordDictionary class:
    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
        word may contain dots '.' where dots can be matched with any letter.

 */
public class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        TrieNode() {
            children = new HashMap<>();
        }
    }

    TrieNode root = new TrieNode();
    WordDictionary() {}

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchWord(word, 0, root);
    }

    private boolean searchWord(String word, int index, TrieNode node) {
        if (index == word.length() && node.isWord)
            return true;

        char ch = word.charAt(index);
        if (node.children.containsKey(ch)) {
            return searchWord(word, index + 1, node.children.get(ch));
        }
        if (ch == '.') {
            for (TrieNode next : node.children.values()) {
                if (searchWord(word, index + 1, next))
                    return true;
            }
        }
        return false;
    }
}
