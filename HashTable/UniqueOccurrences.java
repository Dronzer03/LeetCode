package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// LC - 1207
// https://leetcode.com/problems/unique-number-of-occurrences/
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        Set<Integer> uniqueValues = new HashSet<>(map.values());
        return uniqueValues.size() == map.size();
    }
}
