package Recursion;

import java.util.ArrayList;
import java.util.List;

// LC - 46
// https://leetcode.com/problems/permutations
public class Permutations {
    public List<List<Integer>> findAllPermutations(int[] arr, boolean[] arrMap, List<List<Integer>> result,
            List<Integer> currList) {
        if (currList.size() == arr.length) {
            result.add(new ArrayList<>(currList));
            return result;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!arrMap[i]) {
                currList.add(arr[i]);
                arrMap[i] = true;
                findAllPermutations(arr, arrMap, result, currList);
                currList.remove(Integer.valueOf(arr[i]));
                arrMap[i] = false;
            }
        }
        return result;
    }

    public List<List<Integer>> findAllPermutationsOptimally(int[] arr, List<List<Integer>> result, int i) {
        if (i == arr.length) {
            List<Integer> currList = new ArrayList<>();
            for (int j : arr) {
                currList.add(j);
            }
            result.add(currList);
            return result;
        }

        for (int k = i; k < arr.length; k++) {
            swap(i, k, arr);
            findAllPermutationsOptimally(arr, result, i + 1);
            swap(i, k, arr);
        }
        return result;
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        boolean[] arrMap = new boolean[arr.length];
        Permutations permutations = new Permutations();
        System.out.println("Approach 1");
        permutations.findAllPermutations(arr, arrMap, new ArrayList<>(), new ArrayList<>())
                .forEach(list -> System.out.println(list.toString()));

        System.out.println("Approach 2");

        permutations.findAllPermutationsOptimally(arr, new ArrayList<>(), 0)
                .forEach(list -> System.out.println(list.toString()));
    }
}
