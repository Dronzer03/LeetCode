package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return findAllUniqueSubsets(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> findAllUniqueSubsets(int[] nums, int i, List<List<Integer>> result,
            List<Integer> currList) {
        if (i == nums.length) {
            result.add(new ArrayList<>(currList));
            return result;
        }

        currList.add(nums[i]);
        result = findAllUniqueSubsets(nums, i + 1, result, currList);

        currList.remove(Integer.valueOf(nums[i]));
        int k = i + 1;
        while (k < nums.length && nums[k] == nums[k - 1]) {
            k++;
        }
        result = findAllUniqueSubsets(nums, k, result, currList);
        return result;
    }

    public static void main(String[] args) {
        // Input: nums = [1,2,2]
        // Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        int[] nums = { 1, 2, 2 };
        Subsets2 sub = new Subsets2();
        sub.subsetsWithDup(nums).forEach(list -> System.out.println(list.toString()));
    }
}
