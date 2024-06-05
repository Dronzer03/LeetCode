import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScratchPad {

    public static int fact(int n) {
        if (n == 0)
            return 1;
        return n * fact(n - 1);
    }

    public static int[] reverse(int[] nums, int start, int end) {
        if (start > end)
            return nums;

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        return reverse(nums, ++start, --end);
    }

    public static int[] reverse(int[] nums, int n) {
        if (n == nums.length / 2)
            return nums;

        int temp = nums[n];
        nums[n] = nums[nums.length - 1 - n];
        nums[nums.length - 1 - n] = temp;
        return reverse(nums, ++n);
    }

    public static boolean palindrome(String s, int i) {
        if (i == s.length() / 2)
            return true;

        if (s.charAt(i) == s.charAt(s.length() - i - 1))
            return palindrome(s, ++i);
        return false;
    }

    public static int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static int[] testMethod(int[] arrival) {
        int currTime = 0;
        int[] departure = new int[arrival.length];
        for (int i=0; i<arrival.length; i++) {
            int queueSize = 0;
            int arrivalTime = arrival[i];
            if (currTime < arrivalTime)
                currTime = arrivalTime;
            for (int j = 0; j < i; j++) {
                if (departure[j] > arrivalTime) {
                    queueSize++;
                }
            }
            if (queueSize <= 10) {
                departure[i] = currTime + 300;
                currTime = departure[i];
            }
            else
                departure[i] = arrival[i];
        }
        return departure;
    }

    public static void subSequence(int i, List<Integer> numList, int[] nums) {
        if (i >= nums.length) {
            System.out.println(numList.toString());
            return;
        }

        numList.add(nums[i]);
        subSequence(i + 1, numList, nums);
        numList.remove(Integer.valueOf(nums[i]));
        subSequence(i + 1, numList, nums);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        findCombinations(candidates, target - candidates[index], index + 1, result, currList);
        currList.remove(currList.size() - 1);

        int k = index + 1;
        while (k < candidates.length && candidates[k] == candidates[index]) {
            k++;
        }
        findCombinations(candidates, target, k, result, currList);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fact(4));
        int[] nums = { 1, 2, 3, 4 };
        // System.out.println(Arrays.toString(reverse(nums, 0)));
        System.out.println(palindrome("bbaabb", 0));
        System.out.println(fibo(9));
        subSequence(0, new ArrayList<>(), nums);
        int times[] = {4, 400, 450, 500};
        System.out.println(Arrays.toString(testMethod(times)));
        // 3 1 2 2 1 5
        // 0 0 0 0 0 1
    }
}
