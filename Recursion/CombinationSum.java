package Recursion;

import java.util.ArrayList;
import java.util.List;

// LC - 39
// https://leetcode.com/problems/combination-sum
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combi = new CombinationSum();
        int[] nums = {2, 5, 2, 1, 2};
        combi.combinationSum(nums, 4).stream().forEach(list -> System.out.println(list.toString()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return findCombinations(candidates, target, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> findCombinations(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> currList) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(currList));
            }
            return result;
        }

        if (target < 0)
            return result;

        currList.add(candidates[index]);
        findCombinations(candidates, target - candidates[index], index, result, currList);
        currList.remove(currList.size() - 1);
        findCombinations(candidates, target, index + 1, result, currList);

        return result;
    }
}
