package TwoPointers;

public class TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int[] nums = new int[2];
        int i=0, j=numbers.length-1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum==target) {
                nums[0] = i+1;
                nums[1] = j+1;
                return nums;
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return nums;
    }
}
