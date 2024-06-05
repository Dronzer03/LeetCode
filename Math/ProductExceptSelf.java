package Math;

// LC - 238
// https://leetcode.com/problems/product-of-array-except-self
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        int prefix = 1;
        for (int index = 0; index < nums.length; index++) {
            res[index] = prefix;
            prefix *= nums[index];
        }

        int postfix = 1;
        for (int index = nums.length - 1; index >=0; index--) {
            res[index] *= postfix;
            postfix *= nums[index];
        }

        return res;
    }
}
