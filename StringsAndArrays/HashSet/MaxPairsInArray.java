package StringsAndArrays.HashSet;

import java.util.HashSet;
import java.util.Set;

// LC - 2341
// https://leetcode.com/problems/maximum-number-of-pairs-in-array
public class MaxPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int pairs = 0;
        for (int n : nums) {
            if (numbers.contains(n)) {
                numbers.remove(n);
                pairs++;
            } else {
                numbers.add(n);
            }
        }
        return new int[]{pairs, numbers.size()};
    }
}
