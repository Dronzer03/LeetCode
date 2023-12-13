package StringsAndArrays.HashTable;

import java.util.HashMap;
import java.util.Map;

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
}
