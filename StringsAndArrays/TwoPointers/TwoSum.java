package StringsAndArrays.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numSet = new HashMap<>();
        int temp[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (numSet.containsKey(target - curr)) {
                temp[0] = numSet.get(target - curr);
                temp[1] = i;
                return temp;
            } else {
                numSet.put(curr, i);
            }
        }
        return temp;
    }
}
