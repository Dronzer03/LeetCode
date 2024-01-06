package Math;

// LC - 2980
// https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros
public class BitwiseORTrailingZeros {
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (n%2==0)
                count++;
        }
        return count >= 2;
    }
}
