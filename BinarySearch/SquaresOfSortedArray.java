package BinarySearch;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int negativeIndex = binarySearch(nums, 0, nums.length - 1);

        int[] result = new int[nums.length];
        int index = 0;

        int positiveIndex = negativeIndex + 1;

        while (negativeIndex >= 0 && positiveIndex < nums.length) {
            if (Math.abs(nums[negativeIndex]) <= Math.abs(nums[positiveIndex])) {
                result[index++] = nums[negativeIndex] * nums[negativeIndex--];
            } else {
                result[index++] = nums[positiveIndex] * nums[positiveIndex++];
            }
        }

        while (negativeIndex >= 0) {
            result[index++] = nums[negativeIndex] * nums[negativeIndex--];
        }

        while (positiveIndex < nums.length)
            result[index++] = nums[positiveIndex] * nums[positiveIndex++];

        return result;
    }

    private int binarySearch(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end)
            return -1;
        if (start == end)
            return start;
        if (nums[mid] >= 0)
            return binarySearch(nums, start, mid - 1);

        if (nums[mid] < 0 && mid + 1 < nums.length && nums[mid + 1] >= 0)
            return mid;
        else
            return binarySearch(nums, mid + 1, end);
    }

    public int[] sortedSquaresOptimal(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2};
        System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(nums)));
    }
}
