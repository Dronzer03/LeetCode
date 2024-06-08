package Math;

import java.util.HashMap;
import java.util.Map;

public class CheckSubArraySum {

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new CheckSubArraySum().checkSubarraySum(nums, 1));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>() {{
            put(0, -1);
        }};
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null && i - prev > 1)
                return true;
            else
                map.put(runningSum, i);
        }
        return false;
    }

    public boolean checkSubarraySumBruteForce(int[] nums, int k) {
        return checkSum(nums, k, 0, 0, 0);
    }

    private boolean checkSum(int[] nums, int k, int index, int sum, int start) {
        if (index == nums.length)
            return false;

        sum += nums[index];
        if (index - start >= 1 && sum % k == 0)
            return true;

        return checkSum(nums, k, index + 1, sum, start) ||
                checkSum(nums, k, index + 1, 0, index + 1);
    }
}
