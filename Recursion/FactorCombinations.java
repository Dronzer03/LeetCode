package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findCombinations(int n) {
        findFactors(n, 2);
        return result;
    }

    private void findFactors(int n, int current) {
        if (!currList.isEmpty()) {
            List<Integer> list = new ArrayList<>(currList);
            list.add(n);
            result.add(list);
        }

        for (int j = current; j <= n / j; j++) {
            if (n % j == 0) {
                currList.add(j);
                findFactors(n / j, j);
                currList.remove(currList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FactorCombinations().findCombinations(20).toString());
    }
}
