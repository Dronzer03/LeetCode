package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        Set<Integer> uniqueValues = new HashSet<>();
        for (int n : map.values()) {
            if (uniqueValues.contains(n))
                return false;
            uniqueValues.add(n);
        }
        return true;
    }
}
