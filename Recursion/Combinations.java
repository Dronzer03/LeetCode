package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        return findCombinations(n, k, 1, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> findCombinations(int n, int k, int i, List<List<Integer>> result, List<Integer> currList) {
        if (currList.size()==k) {
            result.add(new ArrayList<>(currList));
            return result;
        }

        if (i > n)
            return result;

        currList.add(i);
        result = findCombinations(n, k, i+1, result, currList);

        currList.remove(Integer.valueOf(i));
        result = findCombinations(n, k, i+1, result, currList);

        return result;
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.combine(4, 2).stream().forEach(list -> System.out.println(list.toString()));
    }
}
