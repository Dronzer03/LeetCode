package DynamicProgramming;

// LC - 64
// https://leetcode.com/problems/minimum-path-sum
public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return uniquePaths(0, 0, grid.length, grid[0].length, dp, grid);
    }

    // Memoization
    private static int uniquePaths(int i, int j, int m, int n, Integer[][] dp, int[][] grid) {
        if (i == m - 1 && j == n - 1)
            return grid[i][j];

        if (i == m || j == n)
            return Integer.MAX_VALUE;

        if (dp[i][j] != null)
            return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min(
                uniquePaths(i + 1, j, m, n, dp, grid),
                uniquePaths(i, j + 1, m, n, dp, grid)
        );

    }

    public static int minPathSumDp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0)
                    continue;

                dp[i][j] = grid[i][j];
                int res = 0;
                if (i - 1 >= 0)
                    res = dp[i - 1][j];

                if (j - 1 >= 0)
                    if (res > 0)
                        res = Math.min(res, dp[i][j - 1]);
                    else
                        res = dp[i][j - 1];

                dp[i][j] += res;
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(minPathSum(grid));
        System.out.println(minPathSum(grid2));

        System.out.println(minPathSumDp(grid));
        System.out.println(minPathSumDp(grid2));
    }
}
