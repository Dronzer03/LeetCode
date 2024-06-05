package TwoPointers;

// LC - 31
// https://leetcode.com/problems/next-permutation
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
        for (int index = nums.length - 2; index >= 0; index--) {
            if (nums[index] < nums[index + 1]) {
                breakPoint = index;
                break;
            }
        }

        if (breakPoint == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int index = nums.length - 1; index > breakPoint; index--) {
            if (nums[index] > nums[breakPoint]) {
                int temp = nums[index];
                nums[index] = nums[breakPoint];
                nums[breakPoint] = temp;
                break;
            }
        }

        reverse(nums, breakPoint + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
