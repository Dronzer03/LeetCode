package HashTable;

import java.util.*;

// LC - 1481
// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removal
public class LeastUniqueNumbers {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        if (k == 0)
            return map.size();

        List<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies);

        int elementsRemoved = 0;

        for (int i = 0; i < frequencies.size(); i++) {
            // Removing frequencies[i] elements, which equates to
            // removing one unique element
            elementsRemoved += frequencies.get(i);

            // If the number of elements removed exceeds k, return
            // the remaining number of unique elements
            if (elementsRemoved > k) {
                return frequencies.size() - i;
            }
        }
        return 0;
    }
}
