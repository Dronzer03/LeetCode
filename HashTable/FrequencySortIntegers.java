package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencySortIntegers {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return Arrays.stream(nums).boxed().sorted((a, b) -> freq.get(b) != freq.get(a) ? freq.get(b) - freq.get(a) : b - a)
                .mapToInt(num -> num).toArray();
    }
}
