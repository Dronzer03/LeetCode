package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LC - 15
// https://leetcode.com/problems/3sum
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int val = nums[i];
            if (i > 0 && val == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int threeSum = val + nums[j] + nums[k];
                if (threeSum > 0) {
                    k--;
                } else if (threeSum < 0) {
                    j++;
                } else {
                    temp = new ArrayList<>();
                    temp.add(val);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
