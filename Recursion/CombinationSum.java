package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumTarget(candidates, 0, new ArrayList<>(), 0, target, new ArrayList<>());
    }

    private List<List<Integer>> combinationSumTarget(int[] candidates, int i, List<List<Integer>> result, int sum, int target, List<Integer> currList) {
        if (sum==target) {
            result.add(new ArrayList<>(currList));
            return result;
        }
        if (sum > target || i == candidates.length) {
            return result;
        }
        currList.add(candidates[i]);
        sum += candidates[i];
        
        result = combinationSumTarget(candidates, i, result, sum, target, currList);
        
        sum -= candidates[i];
        currList.remove(Integer.valueOf(candidates[i]));

        result = combinationSumTarget(candidates, i+1, result, sum, target, currList);
        return result;
    }

    public static void main(String[] args) {
        CombinationSum combi = new CombinationSum();
        int[] nums = {2,4};
        combi.combinationSum(nums, 4).stream().forEach(list -> System.out.println(list.toString()));
    }
}
