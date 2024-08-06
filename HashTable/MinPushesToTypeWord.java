package HashTable;

import java.util.Arrays;

// LC - 3016
// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii
public class MinPushesToTypeWord {
    public int minimumPushes(String word) {
        int[] map = new int[26];

        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }

        Arrays.sort(map);
        int result = 0;
        int pushes = 1;
        for (int index = 25; index >= 0; index--) {
            if (map[index] == 0)
                break;

            if (index == 17)
                pushes = 2;

            if (index == 9)
                pushes = 3;

            if (index == 1)
                pushes = 4;

            result += (pushes * map[index]);
        }

        return result;

    }
}
