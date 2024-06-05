package HashTable;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length== 1)
            return nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
        }
        int maxCount = 0;
        int lastInt = Integer.MIN_VALUE;
        int currCount = 1;
        while (!pq.isEmpty()) {
            int n = pq.poll();
            if (maxCount==0) {
                ++maxCount;
                lastInt = n;
                continue;
            }
            if (n == lastInt)
                continue;
            if (n == lastInt + 1) {
                currCount++;
                maxCount = Math.max(maxCount, currCount);
            } else {
                currCount = 1;
            }
            lastInt = n;
        }
        return maxCount;
    }

    public static int longestConsecutiveSequenceOptimal(int[] nums) {
        if (nums.length == 0 || nums.length== 1)
            return nums.length;
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        int max = 1;
        for (int n : numSet) {
            if (!numSet.contains(n-1)) {
                int k = n+1;
                while (numSet.contains(k)) {
                    k = k + 1;
                }
                max = Math.max(max, k-n);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutiveSequenceOptimal(nums));
    }
}
