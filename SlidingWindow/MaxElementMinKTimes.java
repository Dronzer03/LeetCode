package SlidingWindow;

public class MaxElementMinKTimes {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int n : nums)
            max = Math.max(n, max);

        int i=0, j=0;
        int countMax = 0;
        long ans = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[j] == max) {
                countMax++;
            }
            while (countMax >= k) {
                if (nums[i] == max) {
                    countMax--;
                }
                i++;
                ans += nums.length - j;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        System.out.println(new MaxElementMinKTimes().countSubarrays(nums, 2));
    }
}
