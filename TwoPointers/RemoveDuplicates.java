package TwoPointers;

// LC - 26
// https://leetcode.com/problems/remove-duplicates-from-sorted-array
public class RemoveDuplicates {
    //From Sorted Array
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int currIndex = 1; currIndex < nums.length; currIndex++) {
            if (nums[currIndex] != nums[currIndex-1]) {
                nums[index++] = nums[currIndex];
            }
        }
        return index;
    }
}
