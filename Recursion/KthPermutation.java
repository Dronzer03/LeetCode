package Recursion;

import java.util.ArrayList;
import java.util.List;

// LC - 60
// https://leetcode.com/problems/permutation-sequence
public class KthPermutation {

    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        // Calculate Factorial of n-1 and add count to list
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);
        String ans = "";
        k--;
        while (true) {
            ans += nums.get(k / fact);
            nums.remove(k / fact);
            if (nums.isEmpty())
                break;
            k = k % fact;
            n--;
            fact = fact / n;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 2));
    }
}
