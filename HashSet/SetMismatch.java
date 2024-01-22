package HashSet;

import java.util.HashSet;
import java.util.Set;

// LC - 645
// https://leetcode.com/problems/set-mismatch
public class SetMismatch {

    // Set Implementation
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            if (set.contains(n))
                res[0] = n;
            else
                set.add(n);
        }
        for (int i=1; i<=nums.length; i++) {
            if (!set.contains(i)) {
                res[1] = i;
                return res;
            }
        }
        return res;
    }

    // Frequency Array
    public int[] findError(int[] nums) {
        int[] res = new int[2];
        int[] freq = new int[nums.length + 1];
        for (int n : nums)
                freq[n]++;
        for (int i = 1; i <= nums.length; i++) {
            if (freq[i] == 2)
                res[0] = i;
            if (freq[i] == 0)
                res[1] = i;
        }
        return res;
    }
}
