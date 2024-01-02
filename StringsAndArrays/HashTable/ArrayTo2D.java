package StringsAndArrays.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// LC - 2610
// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions
public class ArrayTo2D {

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> count = new ConcurrentHashMap<>();
        for (int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);
        List<List<Integer>> result = new ArrayList<>();
        while (!count.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                currList.add(entry.getKey());
                if (entry.getValue() == 1)
                    count.remove(entry.getKey());
                else
                    entry.setValue(entry.getValue()-1);
            }
            result.add(currList);
        }
        return result;
    }

    public List<List<Integer>> findMatrixBetter(int[] nums) {
        int[] freq = new int[nums.length+1];
        List<List<Integer>> result = new ArrayList<>();

        for (int n : nums) {
            if (freq[n] >= result.size()) {
                result.add(new ArrayList<>());
            }

            result.get(freq[n]).add(n);
            freq[n]++;
        }

        return result;
    }
}
