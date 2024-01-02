package Recursion;

import java.util.*;

public class Permutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        return findPermutations(nums, 0, new ArrayList<>(), new ArrayList<>(), used);
    }

    private static List<List<Integer>> findPermutations(int[] nums, int index, List<Integer> currList, List<List<Integer>> result, boolean[] used) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currList));
            return result;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]))
                continue;
            currList.add(nums[i]);
            used[i] = true;
            findPermutations(nums, index + 1, currList, result, used);
            used[i] = false;
            currList.remove(currList.size()-1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }
}
