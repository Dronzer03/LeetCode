package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LC - 279
// https://leetcode.com/problems/perfect-squares
public class PerfectSquares {
    // Giving TLE
    public static int numSquares(int n) {
        int square = 1;
        int num = 1;
        List<Integer> squares = new ArrayList<>();
        while (square <= 10000) {
            squares.add(square);
            square = (++num) * num;
        }
        if (squares.contains(n))
            return 1;
        Integer[][][] dp = new Integer[n + 1][n + 1][squares.size()];
        return findLeast(squares, 0, n, 0, dp);
    }

    private static int findLeast(List<Integer> squares, int currCount, int target, int index, Integer[][][] dp) {
        if (index == squares.size()) {
            return target == 0 ? currCount : Integer.MAX_VALUE;
        }

        if (target < 0)
            return Integer.MAX_VALUE;

        if (dp[currCount][target][index] != null)
            return dp[currCount][target][index];

        return dp[currCount][target][index] = Math.min(
                findLeast(squares, currCount + 1, target - squares.get(index), index, dp),
                findLeast(squares, currCount, target, index + 1, dp));
    }

    public int numSquaresOptimal(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
