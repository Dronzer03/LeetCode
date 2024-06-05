package SlidingWindow;

import java.util.*;

// LC - 2461
// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
public class MaxSumSubarraySum {
    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        Map<Integer, Integer> numbers = new HashMap<>();
        long sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            numbers.put(nums[i], numbers.getOrDefault(nums[i], 0) + 1);
            if (i >= k-1) {
                if (numbers.size() == k) {
                    maxSum = Math.max(sum, maxSum);
                }
                sum -= nums[i-k+1];
                numbers.put(nums[i-k+1], numbers.get(nums[i-k+1])-1);
                if (numbers.get(nums[i-k+1]) == 0)
                    numbers.remove(nums[i-k+1]);
            }
        }
        return maxSum;
    }

    public static long maxSum (int[] nums, int k) {
        long maxSum = 0;
        Map<Integer, Integer> numbers = new HashMap<>();
        int left = 0, right = 0;
        long sum = 0;
        while (right < nums.length) {
            if (right - left < k) {
                if (numbers.containsKey(nums[right])) {
                    int newLeft = numbers.get(nums[right]) + 1;
                    while (left < newLeft) {
                        sum -= nums[left];
                        numbers.remove(nums[left++]);
                    }
                }
                sum += nums[right];
                numbers.put(nums[right], right++);
            } else {
                sum -= nums[left];
                numbers.remove(nums[left++]);
                if (numbers.containsKey(nums[right])) {
                    int newLeft = numbers.get(nums[right]) + 1;
                    while (left < newLeft) {
                        sum -= nums[left];
                        numbers.remove(nums[left++]);
                    }
                }
                sum += nums[right];
                numbers.put(nums[right], right++);
            }

            if (numbers.size() == k) {
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,3,1,1};
        System.out.println(maxSum(nums, 3));
    }
}
