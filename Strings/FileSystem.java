package Strings;

import java.util.HashMap;
import java.util.Map;

// LC - 1166
// https://leetcode.com/problems/design-file-system
// Trie
public class FileSystem {
    Map<String, FileSystem> children = new HashMap<>();
    int value;

    FileSystem(int value) {
        this.value = value;
    }

    boolean insert(String path, int value) {
        String[] splittedPath = path.split("/");

        FileSystem node = this;
        for (int index = 1; index < splittedPath.length - 1; index++) {
            String current = splittedPath[index];
            if (!node.children.containsKey(current)) {
                return false;
            }
            node = node.children.get(current);
        }

        if (node.children.containsKey(splittedPath[splittedPath.length - 1]))
            return false;

        node.children.put(splittedPath[splittedPath.length - 1], new FileSystem(value));
        return true;
    }

    int search(String path) {
        FileSystem node = this;
        String[] splittedPath = path.split("/");

        for (int index = 1; index < splittedPath.length; index++) {
            if (node.children.containsKey(splittedPath[index])) {
                node = node.children.get(splittedPath[index]);
            } else {
                return -1;
            }
        }

        return node.value;
    }
}
