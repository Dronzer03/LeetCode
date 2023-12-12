package StringsAndArrays.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }

        List<Integer> values = new ArrayList<>(freqMap.values());
        Collections.sort(values);
        // 1 -> 3
        // 2 --> 2
        // 3 -> 1
        // 3, 2, 1
        // 1, 2, 3
        // top 2 ->
        int minCount = values.get(values.size()-k);
        int index = 0;
        
        for (int n : freqMap.keySet()) {
            if (freqMap.get(n) >= minCount) {
                result[index++] = n;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 1)));
    }
}
