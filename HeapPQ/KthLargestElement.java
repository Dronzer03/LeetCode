package HeapPQ;

import java.util.Collections;
import java.util.PriorityQueue;

// LC - 215
// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums)
            pq.offer(n);

        while (k > 1) {
            pq.poll();
            k--;
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(findKthLargest(nums, 1));
    }
}
