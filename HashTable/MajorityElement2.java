package HashTable;

import java.util.ArrayList;
import java.util.List;

// LC - 229
// https://leetcode.com/problems/majority-element-ii
public class MajorityElement2 {
    public List<Integer> majorityElement2(int[] nums) {
        int count1 = 0;
        int majorityElement1 = 0;
        int count2 = 0;
        int majorityElement2 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != majorityElement2) {
                count1++;
                majorityElement1 = num;
            } else if (count2 == 0 && num != majorityElement1) {
                count2++;
                majorityElement2 = num;
            } else if (num == majorityElement1) {
                count1++;
            } else if (num == majorityElement2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3; // Threshold for majority element

        // Second pass to count occurrences of the potential majority elements.
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (majorityElement1 == nums[i]) {
                count1++;
            } else if (majorityElement2 == nums[i]) {
                count2++;
            }
        }

        // Check if the counts of potential majority elements are greater than n/3 and add them to the result.
        if (count1 > threshold) {
            result.add(majorityElement1);
        }
        if (count2 > threshold) {
            result.add(majorityElement2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,3,1,4,5,6};
        System.out.println(new MajorityElement2().majorityElement2(nums));
    }
}
