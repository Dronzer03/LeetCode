package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static int[] mergeSort(int[] nums, int low, int high) {
        if (low == high)
            return nums;

        int mid = (low+high)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        return merge(nums, low, mid, high);
    }

    public static int[] merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i=low; i<=high; i++) {
            nums[i] = temp.get(i-low);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5};
        System.out.println(Arrays.toString(mergeSort(nums, 0, 4)));
    }
}
