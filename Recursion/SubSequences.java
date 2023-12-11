package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {
    
    public void allSubSequences(int[] nums, int i, List<Integer> numsList) {
        if (i >= nums.length) {
            System.out.println(numsList.toString());
            return;
        }

        numsList.add(nums[i]);
        allSubSequences(nums, i+1, numsList);
        numsList.remove(Integer.valueOf(nums[i]));
        allSubSequences(nums, i+1, numsList);
    }

    public void allSubSequencesWithSumK(int[] nums, int i, int sum, int k, List<Integer> numsList) {
        if (i >= nums.length) {
            if (sum==k) {
                System.out.println(numsList.toString());
            }
            return;
        }
        numsList.add(nums[i]);
        sum += nums[i];
        allSubSequencesWithSumK(nums, i+1, sum, k, numsList);
        numsList.remove(Integer.valueOf(nums[i]));
        sum -= nums[i];
        allSubSequencesWithSumK(nums, i+1, sum, k, numsList);
        return;
    }

    public boolean firstSubSequenceWithSumK(int[] nums, int i, int sum, int k, List<Integer> numsList) {
        if (i == nums.length) {
            if (sum==k) {
                System.out.println(numsList.toString());
                return true;
            }
            return false;
        }

        numsList.add(nums[i]);
        sum += nums[i];
        boolean found = firstSubSequenceWithSumK(nums, i+1, sum, k, numsList);
        if (found)
            return true;
        
        numsList.remove(Integer.valueOf(nums[i]));
        sum -= nums[i];
        found = firstSubSequenceWithSumK(nums, i+1, sum, k, numsList);
        if (found)
            return true;
        return false;
    }

    public int countSubSequenceWithSumK(int[] nums, int i, int sum, int k, int count) {
        if (i == nums.length) {
            if (sum==k) {
                count++;
                return count;
            }
            return count;
        }

        sum += nums[i];
        int c1 = countSubSequenceWithSumK(nums, i+1, sum, k, count);

        sum -= nums[i];
        int c2 = countSubSequenceWithSumK(nums, i+1, sum, k, count);

        return c1+c2;

    }

    public List<Integer> subsetSum(int[] nums, int index, int sum, List<Integer> result) {
        if (index == nums.length) {
            result.add(sum);
            return result;
        }

        sum += nums[index];
        subsetSum(nums, index+1, sum, result);
        sum -= nums[index];
        subsetSum(nums, index+1, sum, result);

        return result;
    }

    public static void main(String[] args) {
        SubSequences sub = new SubSequences();
        int[] nums = {2, 3};
        sub.allSubSequences(nums, 0, new ArrayList<>());
        sub.allSubSequencesWithSumK(nums, 0, 0, 3, new ArrayList<>());
        System.out.println(sub.firstSubSequenceWithSumK(nums, 0, 0, 3, new ArrayList<>()));
        System.out.println(sub.countSubSequenceWithSumK(nums, 0, 0, 2, 0));
        System.out.println(sub.subsetSum(nums, 0, 0, new ArrayList<>()));
    }

}
