package TwoPointers;

// LC - 80
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
public class RemoveDuplicatesMaxOccuranceTwice {
    public static int removeDuplicates(int[] nums) {
        int index = 1;
        int count = 1;
        for (int currIndex = 1; currIndex < nums.length; currIndex++) {
            if (nums[currIndex] == nums[currIndex - 1]) {
                if (count < 2) {
                    nums[index++] = nums[currIndex];
                }
                count++;
            } else {
                nums[index++] = nums[currIndex];
                count = 1;
            }
        }
        return index;
    }
    //[1,1,1,2,2,3]

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 3, 3, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}
