package Graphs;

// Find number of Distinct Island which are connected 8-Directionally
// GFG
// https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
// LC - 200
// https://leetcode.com/problems/number-of-islands
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islands++;
                    dfsGraph(row, col, grid);
                }
            }
        }

        return islands;
    }

    private void dfsGraph(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length)
            return;

        if (grid[row][col] == '0')
            return;

        grid[row][col] = '0';
        dfsGraph(row + 1, col, grid);
        dfsGraph(row, col + 1, grid);
        dfsGraph(row - 1, col, grid);
        dfsGraph(row, col - 1, grid);
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(new NumberOfIslands().numIslands(arr));
    }
}
