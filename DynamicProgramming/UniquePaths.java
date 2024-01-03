package DynamicProgramming;

// LC - 62
// https://leetcode.com/problems/unique-paths
// https://leetcode.com/problems/unique-paths/solutions/4498550/simple-to-understand-memoization-followed-by-tabulation/
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        Integer[][] dp = new Integer[m][n];
        return uniquePaths(0, 0, m, n, visited, dp);
    }

    // Memoization
    private static int uniquePaths(int i, int j, int m, int n, boolean[][] visited, Integer[][] dp) {
        if (i==m-1 && j==n-1)
            return 1;

        if (dp[i][j] != null)
            return dp[i][j];

        int right = 0;
        int down = 0;

        if (i + 1 < m && !visited[i+1][j]) {
            visited[i+1][j] = true;
            right = uniquePaths(i + 1, j, m, n, visited, dp);
            visited[i+1][j] = false;
        }

        if (j + 1 < n && !visited[i][j+1]) {
            visited[i][j+1] = true;
            down = uniquePaths(i, j+1, m, n, visited, dp);
            visited[i][j+1] = false;
        }

        return dp[i][j] = right + down;
    }

    // Tabulation
    public static int uniquePathsDp (int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n;j++) {
                if (i==0 && j==0)
                    continue;
                dp[i][j] = 0;
                if (i -1 >= 0)
                    dp[i][j] += dp[i-1][j];
                if (j - 1 >= 0)
                    dp[i][j] += dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePathsDp(3, 7));
    }
}
