package HashTable;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int elementWithMaxCount = nums[0];
        int maxCount = 1;
        for (int i=0;i<nums.length;i++) {
            if (countMap.containsKey(nums[i])) {
                int currCount = countMap.get(nums[i]);
                currCount++;
                if (currCount > maxCount) {
                    maxCount = currCount;
                    elementWithMaxCount = nums[i];
                }
                countMap.put(nums[i], currCount);
            } else countMap.put(nums[i], 1);
        }
        return elementWithMaxCount;
    }

    public int majorityElementMooreVotingAlgo(int[] nums) {
        int count = 0;
        int majorityElement = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityElement = num;
            }
            if (num == majorityElement) {
                count++;
            } else {
                count--;
            }
        }
        return majorityElement;
    }
}
