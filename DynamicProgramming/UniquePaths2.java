package DynamicProgramming;

// LC - 63
// https://leetcode.com/problems/unique-paths-ii
public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                dp[i][j] = 0;
                if (obstacleGrid[i][j] == 1)
                    continue;
                if (i - 1 >= 0)
                    dp[i][j] += dp[i - 1][j];
                if (j - 1 >= 0)
                    dp[i][j] += dp[i][j - 1];
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        int[][] obstacleGrid2 = {
                {0, 1}, {0, 1}
        };
        int[][] obstacleGrid3 = {
                {1}
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
        System.out.println(uniquePathsWithObstacles(obstacleGrid3));
    }

    public int uniquePaths(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        Integer[][] dp = new Integer[m][n];
        return numberOfPaths(0, 0, m, n, dp, obstacleGrid);
    }

    private int numberOfPaths(int row, int col, int m, int n, Integer[][] dp, int[][] obstacleGrid) {
        if (row == m - 1 && col == n - 1)
            return 1;

        if (row == m || col == n || obstacleGrid[row][col] == 1)
            return 0;

        if (dp[row][col] != null)
            return dp[row][col];

        return dp[row][col] = numberOfPaths(row + 1, col, m, n, dp, obstacleGrid) + numberOfPaths(row, col + 1, m, n, dp, obstacleGrid);
    }
}
