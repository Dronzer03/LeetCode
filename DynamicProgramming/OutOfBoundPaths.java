package DynamicProgramming;

// LC - 576
// https://leetcode.com/problems/out-of-boundary-path
public class OutOfBoundPaths {
    public static int mod = 1000000007;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove + 1];
        return findWays(m, n, maxMove, startRow, startColumn, dp);
    }

    private static int findWays(int m, int n, int maxMove, int row, int col, Integer[][][] dp) {
        if (row == m || col == n || row < 0 || col < 0)
            return 1;

        if (maxMove == 0)
            return 0;

        if (dp[row][col][maxMove] != null)
            return dp[row][col][maxMove];

        int total = 0;
        total = (total + (findWays(m, n, maxMove - 1, row + 1, col, dp) % mod)) % mod;
        total = (total + (findWays(m, n, maxMove - 1, row - 1, col, dp) % mod)) % mod;
        total = (total + (findWays(m, n, maxMove - 1, row, col + 1, dp) % mod)) % mod;
        total = (total + (findWays(m, n, maxMove - 1, row, col - 1, dp) % mod)) % mod;

        return dp[row][col][maxMove] = total % mod;
    }

    public static void main(String[] args) {
        System.out.println(findPaths(1, 3, 3, 0, 1));
    }
}
