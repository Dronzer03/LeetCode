package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LC - 368
// https://leetcode.com/problems/largest-divisible-subset
// This solution gives TLE but good try Dronzer :)
public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return largestDivisibleSubset(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    private static List<Integer> largestDivisibleSubset(int[] nums, int index, List<Integer> result, List<Integer> currList) {
        if (index == nums.length) {
            if (currList.size() > result.size()) {
                result = new ArrayList<>(currList);
            }
            return result;
        }

        if (currList.isEmpty()) {
            currList.add(nums[index]);
            result = largestDivisibleSubset(nums, index + 1, result, currList);
            currList.remove(currList.size() - 1);
        } else {
            if (nums[index] % currList.get(currList.size() - 1) == 0) {
                currList.add(nums[index]);
                result = largestDivisibleSubset(nums, index + 1, result, currList);
                currList.remove(currList.size() - 1);
            }
        }
        result = largestDivisibleSubset(nums, index + 1, result, currList);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,9,18,54,108,540,90,180,360,720};
        System.out.println(largestDivisibleSubset(nums));
    }
}
