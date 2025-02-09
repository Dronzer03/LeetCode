package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LC -
// https://leetcode.com/problems/shortest-word-distance-ii
public class ShortestWordDistance2 {
    Map<String, List<Integer>> wordMap = new HashMap<>();

    ShortestWordDistance2(String[] words) {
        for (int index = 0; index < words.length; index++) {
            wordMap.computeIfAbsent(words[index], k -> new ArrayList<>()).add(index);
        }
    }

    public int findShortestDistance(String word1, String word2) {
        if (!wordMap.containsKey(word1) || !wordMap.containsKey(word2))
            return -1;

        if (word1.equals(word2))
            return 0;

        List<Integer> word1List = wordMap.get(word1);
        List<Integer> word2List = wordMap.get(word2);

        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;

        while (left < word1List.size() && right < word2List.size()) {
            ans = Math.min(ans, Math.abs(word1List.get(left) - word2List.get(right)));
            if (word1List.get(left) <= word2List.get(right))
                left++;
            else
                right++;
        }

        return ans;
    }
}
