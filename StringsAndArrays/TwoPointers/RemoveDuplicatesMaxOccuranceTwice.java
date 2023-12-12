package StringsAndArrays.TwoPointers;

import java.util.Arrays;

public class RemoveDuplicatesMaxOccuranceTwice {
    public static int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;
    
        int currCount = 1;
        int k = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]==nums[i-1]) {
                if (currCount < 2) {
                    currCount++;
                    nums[k++] =  nums[i];
                }
            } else {
                currCount = 1;
                nums[k++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
    //[1,1,1,2,2,3]

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,3,3,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
