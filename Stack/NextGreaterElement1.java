package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> greaterMap = new HashMap<>();
        Stack<Integer> elements = new Stack<>();
        for (int n : nums2) {
            while (!elements.isEmpty() && elements.peek() < n) {
                greaterMap.put(elements.pop(), n);
            }
            elements.push(n);
        }
        int[] result = new int[nums1.length];
        int k = 0;
        for (int n : nums1) {
            result[k++] = greaterMap.getOrDefault(n, -1);
        }
        return result;
    }
}
