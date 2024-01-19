package DynamicProgramming;

// LC - 931
// https://leetcode.com/problems/minimum-falling-path-sum
public class MinimumFallingSum {
    public static int minFallingPathSum(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, findMinPath(matrix, 0, i, dp));
        }
        return min;
    }

    private static int findMinPath(int[][] matrix, int i, int j, Integer[][] dp) {
        if (j < 0 || j >= matrix[i].length)
            return 10001;

        if (i == matrix.length - 1)
            return matrix[i][j];

        if (dp[i][j] != null)
            return dp[i][j];

        return dp[i][j] = matrix[i][j] + Math.min(findMinPath(matrix, i + 1, j - 1, dp),
                Math.min(findMinPath(matrix, i + 1, j, dp), findMinPath(matrix, i + 1, j + 1, dp)));
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}
