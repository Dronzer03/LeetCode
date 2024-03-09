package StringsAndArrays.HashTable;

// LC - 3005
// https://leetcode.com/problems/count-elements-with-maximum-frequency
public class MaxFrequencyElements {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for (int n : nums) {
            freq[n]++;
            max = Math.max(freq[n], max);
        }
        int res = 0;
        for (int n : freq) {
            if (n == max)
                res += max;
        }
        return res;
    }
}
