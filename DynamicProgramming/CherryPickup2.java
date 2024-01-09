package DynamicProgramming;

// LC - 1463
// https://leetcode.com/problems/cherry-pickup-ii
public class CherryPickup2 {

    public static int cherryPickup(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return maxPick(grid, 0, 0, grid[0].length - 1, dp);
    }

    private static int maxPick(int[][] grid, int index, int j1, int j2, Integer[][][] dp) {
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length)
            return Integer.MIN_VALUE;

        if (index == grid.length-1) {
            if (j1 == j2)
                return grid[index][j1];
            return grid[index][j1] + grid[index][j2];
        }

        if (dp[index][j1][j2] != null)
            return dp[index][j1][j2];

        int max = 0;

        for (int deltaJ1 = -1; deltaJ1 <=1; deltaJ1++) {
            for (int deltaJ2 = -1; deltaJ2 <= 1; deltaJ2++) {
                if (j1 == j2)
                    max = Math.max(max, grid[index][j1] + maxPick(grid, index + 1, j1 + deltaJ1, j2 + deltaJ2, dp));
                else
                    max = Math.max(max, grid[index][j1] + grid[index][j2] + maxPick(grid, index + 1, j1 + deltaJ1, j2 + deltaJ2, dp));
            }
        }

        return dp[index][j1][j2] = max;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}};
        int[][] grid2 = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(cherryPickup(grid));
        System.out.println(cherryPickup(grid2));
    }
}
