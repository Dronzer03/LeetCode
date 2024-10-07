package SlidingWindow;

import java.util.*;

// LC - 2461
// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
public class MaxSumDistinctSubArray {
    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        long maxSum = 0;
        long sum = 0;

        for (int index = 0; index < nums.length; index++) {
            countMap.put(nums[index], countMap.getOrDefault(nums[index], 0) + 1);
            sum += nums[index];

            if (index >= k - 1) {
                if (countMap.size() == k)
                    maxSum = Math.max(sum, maxSum);
                sum -= nums[index - k + 1];
                countMap.put(nums[index - k + 1], countMap.get(nums[index - k + 1]) - 1);
                if (countMap.get(nums[index - k + 1]) == 0)
                    countMap.remove(nums[index - k + 1]);
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
