package StringsAndArrays.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i=0; i < nums.length ; i++) {
            if (numsMap.containsKey(nums[i])) {
                if (i - numsMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            numsMap.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicateOptimal(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int i=0; i < nums.length ; i++) {
            if (i > k) {
                numSet.remove(nums[i-k-1]);
            }
            if (numSet.contains(nums[i]))
                return true;
            numSet.add(nums[i]);
        }
        return false;
    }
}
