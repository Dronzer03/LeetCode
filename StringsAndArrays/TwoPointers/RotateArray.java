package StringsAndArrays.TwoPointers;

public class RotateArray {
    
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int count = 0; count<k; count++) {
            int temp = nums[nums.length-1];
            for (int i=nums.length-1; i>0;i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }
    }

    public void rotateByReverse(int[] nums, int k) {
        k = k%nums.length;
        nums = reverse(nums, 0, k-1);
        nums = reverse(nums, k, nums.length-1);
        nums = reverse(nums, 0, nums.length-1);
    }

    public int[] reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
        return nums;
    }
}
