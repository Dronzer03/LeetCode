package DynamicProgramming;

// https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998
public class MaximumPathSumMatrix {
    public static int getMaxPathSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            maxSum = Math.max(maxSum, findMaxPath(0, i, matrix, dp));
        }
        return maxSum;
    }

    // Memoization
    private static int findMaxPath(int i, int j, int[][] matrix, Integer[][] dp) {
        if (i == matrix.length - 1)
            return matrix[i][j];

        if (dp[i][j] != null)
            return dp[i][j];

        int max = Integer.MIN_VALUE;

        if (j - 1 >= 0)
            max = Math.max(max, findMaxPath(i + 1, j - 1, matrix, dp));
        if (j + 1 < matrix[i + 1].length)
            max = Math.max(max, findMaxPath(i + 1, j + 1, matrix, dp));
        max = Math.max(max, findMaxPath(i + 1, j, matrix, dp));

        return dp[i][j] = matrix[i][j] + max;
    }

    // Tabulation
    public int maxSPathSumDp(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j];
                if (i == 0)
                    continue;
                int max = Integer.MIN_VALUE;
                if (j - 1 >= 0)
                    max = Math.max(max, dp[i - 1][j - 1]);
                if (j + 1 < matrix[i - 1].length)
                    max = Math.max(max, dp[i - 1][j + 1]);
                max = Math.max(max, dp[i - 1][j]);
                dp[i][j] += max;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i<matrix[0].length; i++) {
            res = Math.max(res, dp[matrix.length-1][i]);
        }
        return res;
    }
}
