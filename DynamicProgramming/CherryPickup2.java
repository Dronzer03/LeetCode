package DynamicProgramming;

// LC - 1463
// https://leetcode.com/problems/cherry-pickup-ii
public class CherryPickup2 {

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}};
        int[][] grid2 = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        System.out.println(new CherryPickup2().cherryPickup(grid));
        System.out.println(new CherryPickup2().cherryPickup(grid2));
    }

    public int cherryPickup(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return maxPick(grid, 0, 0, grid[0].length - 1, dp);
    }

    private int maxPick(int[][] grid, int row, int robo1Col, int robo2Col, Integer[][][] dp) {
        if (robo1Col < 0 || robo1Col == grid[0].length || robo2Col < 0 || robo2Col == grid[0].length)
            return Integer.MIN_VALUE;

        if (row == grid.length - 1) {
            if (robo1Col == robo2Col)
                return grid[row][robo1Col];
            return grid[row][robo1Col] + grid[row][robo2Col];
        }

        if (dp[row][robo1Col][robo2Col] != null)
            return dp[row][robo1Col][robo2Col];

        int max_val = Integer.MIN_VALUE;
        for (int j1 = -1; j1 <= 1; j1++) {
            for (int j2 = -1; j2 <= 1; j2++) {
                max_val = Math.max(max_val, maxPick(grid, row + 1, robo1Col + j1, robo2Col + j2, dp));
            }
        }

        if (robo1Col == robo2Col)
            return dp[row][robo1Col][robo2Col] = grid[row][robo1Col] + max_val;
        return dp[row][robo1Col][robo2Col] = grid[row][robo1Col] + grid[row][robo2Col] + max_val;
    }
}
