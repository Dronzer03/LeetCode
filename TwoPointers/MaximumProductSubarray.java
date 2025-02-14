package TwoPointers;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;

        int left = 0;
        int right = n - 1;

        int ansLeft = -1;
        int ansRight = -1;

        int preLeft = 0;
        int suffRight = n - 1;

        while (n-- > 0) {
            prefix *= nums[left++];
            suffix *= nums[right--];
            if (prefix > max) {
                max = prefix;
                ansLeft = preLeft;
                ansRight = left - 1;
            }
            if (suffix > max) {
                max = suffix;
                ansLeft = right + 1;
                ansRight = suffRight;
            }
            if (prefix == 0) {
                prefix = 1;
                if (max == 0)
                    ansLeft = ansRight = left - 1;
            }
            if (suffix == 0) {
                suffix = 1;
                if (max == 0)
                    ansLeft = ansRight = right + 1;
            }
        }
        System.out.println(ansLeft);
        System.out.println(ansRight);
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        m.maxProduct(new int[]{2, 3, -2, 4});
        m.maxProduct(new int[]{1, 2, 3, 4});
        m.maxProduct(new int[]{2, 0, 3, 4});
        m.maxProduct(new int[]{-2, -3, -4});
        m.maxProduct(new int[]{5});
        m.maxProduct(new int[]{2, 0, -1, 0, 3});
        m.maxProduct(new int[]{2, 3, 4, 0});
        m.maxProduct(new int[]{0, 2, 3, 4});
    }
}
