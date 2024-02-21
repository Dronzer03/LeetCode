package StringsAndArrays.Math;

// LC - 201
// https://leetcode.com/problems/bitwise-and-of-numbers-range
public class BitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        while(right>left)
            right = right & right-1;
        return right & left;
    }
}
