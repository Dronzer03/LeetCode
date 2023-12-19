package Recursion;

import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i=1; i<n ;i++) {
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
        System.out.println(getPermutation(2, 2));
    }
}
