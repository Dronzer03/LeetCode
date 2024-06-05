package Strings;

// LC - 2149
// https://leetcode.com/problems/rearrange-array-elements-by-sign
public class RearrangeBySign {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0;
        int neg = 1;
        for (int n  : nums) {
            if (n < 0) {
                res[neg] = n;
                neg += 2;
            } else {
                res[pos] = n;
                pos += 2;
            }
        }
        return res;
    }
}
