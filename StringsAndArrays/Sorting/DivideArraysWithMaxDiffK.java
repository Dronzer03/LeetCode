package StringsAndArrays.Sorting;

import java.util.Arrays;

// LC - 2966
// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference
public class DivideArraysWithMaxDiffK {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[(nums.length)/3][3];
        int index = 0;
        for (int i=0; i<nums.length; i+=3) {
            if (nums[i+2] - nums[i] > k)
                return new int[k/3][3];
            int[] arr = new int[3];
            arr[0] = nums[i];
            arr[1] = nums[i+1];
            arr[2] = nums[i+2];
            result[index++] = arr;
        }
        return result;
    }
}
