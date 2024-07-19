package DynamicProgramming;

// LC - 62
// https://leetcode.com/problems/unique-paths
// https://leetcode.com/problems/unique-paths/solutions/4498550/simple-to-understand-memoization-followed-by-tabulation/
public class UniquePaths {
    // Tabulation
    public static int uniquePathsDp(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                dp[i][j] = 0;
                if (i - 1 >= 0)
                    dp[i][j] += dp[i - 1][j];
                if (j - 1 >= 0)
                    dp[i][j] += dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePathsDp(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return numberOfPaths(0, 0, m, n, dp);
    }

    private static int numberOfPaths(int row, int col, int m, int n, Integer[][] dp) {
        if (row == m - 1 && col == n - 1)
            return 1;

        if (row == m || col == n)
            return 0;

        if (dp[row][col] != null)
            return dp[row][col];

        return dp[row][col] = numberOfPaths(row + 1, col, m, n, dp) + numberOfPaths(row, col + 1, m, n, dp);
    }
}
