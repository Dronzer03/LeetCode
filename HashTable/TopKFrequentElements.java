package HashTable;

import java.util.*;

// LC - 347
// https://leetcode.com/problems/top-k-frequent-elements
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

    // O(n) Solution
    public int[] topKFrequentOptimal(int[] nums, int k) {
        int[] result = new int[k];
        Bucket tail = null;

        Map<Integer, Bucket> frequencyVsBucket = new HashMap<>();
        Map<Integer, Integer> frequncyMap = new HashMap<>();

        for (int n : nums) {
            if (frequncyMap.containsKey(n)) {
                int currFreq = frequncyMap.get(n);
                Bucket currBucket = frequencyVsBucket.get(currFreq);
                currBucket.numbers.remove(n);
                currFreq++;
                Bucket newBucket = frequencyVsBucket.getOrDefault(currFreq, null);
                if (newBucket == null) {
                    newBucket = new Bucket();
                    newBucket.frequency = currFreq;
                    tail =  newBucket;
                    frequencyVsBucket.put(currFreq, newBucket);
                }
                newBucket.numbers.add(n);
                frequncyMap.put(n, currFreq);
            } else {
                if (tail == null) {
                    tail = new Bucket();
                    tail.frequency = 1;
                    frequencyVsBucket.put(1, tail);
                }
                frequencyVsBucket.get(1).numbers.add(n);
                frequncyMap.put(n, 1);
            }
        }

        int maxFreq = tail.frequency;
        int index = 0;
        while (index < k) {
            Bucket b = frequencyVsBucket.get(maxFreq--);
            Iterator<Integer> itr = b.numbers.iterator();
            while (index < k && itr.hasNext()) {
                result[index++] = itr.next();
            }
        }

        return result;
    }

    class Bucket {
        int frequency;
        Set<Integer> numbers = new HashSet<>();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 1)));
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequentOptimal(nums, 1)));
    }
}
