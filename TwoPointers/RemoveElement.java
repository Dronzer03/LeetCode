package TwoPointers;

// LC - 27
// https://leetcode.com/problems/remove-element
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int currIndex = 0; currIndex < nums.length; currIndex++) {
            if (nums[currIndex] != val) {
                nums[index++] = nums[currIndex];
            }
        }
        return index;
    }
}
