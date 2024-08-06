package SlidingWindow;

// https://leetcode.com/problems/minimum-size-subarray-sum/
// LC-209
public class MinSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int end = -1;
        int minLen = nums.length + 1;

        while (end < nums.length) {
            if (sum < target) {
                end++;
                if (end < nums.length)
                    sum += nums[end];
            } else if (sum >= target) {
                minLen = Math.min(end-start+1, minLen);
                sum -= nums[start];
                if (start == end)
                    end++;
                start++;
            }

        }
        if (minLen == nums.length + 1)
            return 0;
        return minLen;
    }

    public int minSubArrayLenBetter(int target, int[] nums) {
        int left = 0;
        int right = 0;

        int sum = 0;
        int min = nums.length + 1;
        while (left < nums.length && right < nums.length) {
            sum += nums[right];
            if (sum < target) {
                right++;
            } else {
                while (sum >= target && left <= right) {
                    min = Math.min(min, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
                right++;
            }
        }

        return min == nums.length + 1 ? 0 : min;
    }

    public static void main(String[] args) {
        MinSizeSubArraySum minSizeSubArraySum = new MinSizeSubArraySum();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(minSizeSubArraySum.minSubArrayLen(7, nums));
    }
}
