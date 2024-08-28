package DynamicProgramming;

import java.util.Arrays;

// LC - 1937
// https://leetcode.com/problems/maximum-number-of-points-with-cost
// TLE - 156/157
public class MaxPointsWithCost {
    public long maxPoints(int[][] points) {
        long[][] dp = new long[points.length][points[0].length];
        long maxVal = Integer.MIN_VALUE;

        for (int index = 0; index < points[0].length; index++) {
            dp[0][index] = points[0][index];
            if (points.length == 1)
                maxVal = Math.max(maxVal, dp[0][index]);
        }

        if (points.length == 1)
            return maxVal;

        for (int row = 1; row < points.length; row++) {
            Arrays.fill(dp[row], Integer.MIN_VALUE);
            for (int col = 0; col < points[0].length; col++) {
                long val = points[row][col];
                for (int prevCol = 0; prevCol < points[0].length; prevCol++) {
                    dp[row][col] = Math.max(dp[row][col], val + dp[row - 1][prevCol] - Math.abs(col - prevCol));
                }
                if (row == points.length - 1)
                    maxVal = Math.max(maxVal, dp[row][col]);
            }
        }

        return maxVal;
    }
}
