package StringsAndArrays.HashTable;

import java.util.HashMap;
import java.util.Map;

public class MinOperationToMakeArrayEmpty {
    public static int minOperations(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums)
            counts.put(n, counts.getOrDefault(n, 0) + 1);

        int result = 0;
        for (int n : counts.values()) {
            if (n == 1)
                return -1;
            if (n % 3 == 0)
                result += n / 3;
            else
                result += (n / 3) + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2, 2, 4, 2, 3, 4};
        int[] nums2 = {2, 1, 2, 2, 3, 3};
        int[] nums3 = {14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12};
        System.out.println(minOperations(nums));
        System.out.println(minOperations(nums2));
        System.out.println(minOperations(nums3));
    }
}
