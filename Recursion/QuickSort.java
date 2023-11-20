package Recursion;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] nums, int low, int high) {

        if (low >= high)
            return nums;
        
        int pivot = nums[low];
        int left = low;
        int right = high;

        while (left < right) {
            while (nums[left] <= pivot && left<=high-1)
                left++;
            
            while (nums[right] > pivot && right>=low+1)
                right--;

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
                
        }

        nums[low] = nums[right];
        nums[right] = pivot;
        
        quickSort(nums, low, right-1);
        quickSort(nums, right+1, high);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,2,5,1};
        System.out.println(Arrays.toString(quickSort(nums, 0, 4)));
    }
}
