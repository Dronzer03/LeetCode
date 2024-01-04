package StringsAndArrays.HashTable;

//LC - 2342
// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
public class MaxSumOfPairWithEqualSumDigits {
    public static int maximumSum(int[] nums) {
        int[] map = new int[82];
        int maxSum = -1;
        for (int n : nums) {
            int sum = calculateSum(n);
            if (map[sum] != 0) {
                maxSum = Math.max(maxSum, n + map[sum]);
                map[sum] = Math.max(n, map[sum]);
            } else {
                map[sum] = n;
            }
        }
        return maxSum;
    }

    private static int calculateSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7};
        int[] nums2 = {10,12,19,14};
        int[] nums3 = {1000,100,1,1,1000,55,19};
        System.out.println(maximumSum(nums));
        System.out.println(maximumSum(nums2));
        System.out.println(maximumSum(nums3));
    }
}
