package Recursion;

import java.util.*;

// LC - 40
// https://leetcode.com/problems/combination-sum-ii
public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combi = new CombinationSum2();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        // combi.combinationSum2BetterApproach(nums, 8).stream().forEach(list ->
        // System.out.println(list.toString()));
        combi.combinationSum2EvenBetterApproach(nums, 8).stream().forEach(list -> System.out.println(list.toString()));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = findDistinctCombinations(candidates, target, new HashSet<>(), new ArrayList<>(), 0);
        List<List<Integer>> resList = new ArrayList<>();
        result.stream().forEach(res -> resList.add(res));
        return resList;
    }

    private Set<List<Integer>> findDistinctCombinations(int[] candidates, int target, Set<List<Integer>> result,
                                                        List<Integer> currList, int i) {
        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return result;
        }

        if (target < 0 || i == candidates.length)
            return result;

        // take
        target -= candidates[i];
        currList.add(candidates[i]);
        result = findDistinctCombinations(candidates, target, result, currList, i + 1);

        // not take
        target += candidates[i];
        currList.remove(Integer.valueOf(candidates[i]));
        result = findDistinctCombinations(candidates, target, result, currList, i + 1);
        return result;
    }

    public List<List<Integer>> combinationSum2BetterApproach(int[] candidates, int target) {
        Arrays.sort(candidates);
        return findDistinctCombinationsBetterApproach(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private List<List<Integer>> findDistinctCombinationsBetterApproach(int[] candidates, int target,
                                                                       List<List<Integer>> result, List<Integer> currList, int i) {
        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return result;
        }

        if (target < 0 || i == candidates.length)
            return result;

        target -= candidates[i];
        currList.add(candidates[i]);
        result = findDistinctCombinationsBetterApproach(candidates, target, result, currList, i + 1);

        target += candidates[i];
        currList.remove(Integer.valueOf(candidates[i]));
        int k = i + 1;
        while (k < candidates.length && candidates[i] == candidates[k]) {
            k++;
        }
        result = findDistinctCombinationsBetterApproach(candidates, target, result, currList, k);
        return result;
    }

    public List<List<Integer>> combinationSum2EvenBetterApproach(int[] candidates, int target) {
        Arrays.sort(candidates);
        return findDistinctCombinationsEvenBetterApproach(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private List<List<Integer>> findDistinctCombinationsEvenBetterApproach(int[] candidates, int target,
                                                                           List<List<Integer>> result, List<Integer> currList, int i) {
        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return result;
        }

        for (int k = i; k < candidates.length; k++) {
            if (k > i && candidates[k] == candidates[k - 1])
                continue;

            if (candidates[k] > target)
                break;

            currList.add(candidates[k]);
            findDistinctCombinationsEvenBetterApproach(candidates, target - candidates[k], result, currList, k + 1);
            currList.remove(currList.size() - 1);
        }
        return result;
    }
}