package DynamicProgramming;

import java.util.ArrayList;

// LC - 446
// https://leetcode.com/problems/arithmetic-slices-ii-subsequence
public class ArithmeticSlices2 {

    public static int numberOfArithmeticSlices(int[] nums) {
        return findSlices(nums, 0, new ArrayList<>());
    }

    private static int findSlices(int[] nums, int index, ArrayList<Integer> currList) {
        // It is a valid sequence only if sequence is of Length 3 or more
        if (index == nums.length)
            return currList.size() >= 3 ? 1 : 0;

        // take case
        // take only if difference between 1st and 2nd element is same as difference between last element in the list and
        // current element
        int take = 0;
        if (currList.size() < 2 || currList.get(1) - currList.get(0) == nums[index] - currList.get(currList.size() - 1)) {
            currList.add(nums[index]);
            take = findSlices(nums, index + 1, currList);
            currList.remove(currList.size()-1);
        }
        // not take case
        // Skip and move forward
        // Add them up and return the result
        return take + findSlices(nums, index + 1, currList);

    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
