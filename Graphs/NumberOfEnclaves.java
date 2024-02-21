package Graphs;

// LC - 1020
// https://leetcode.com/problems/number-of-enclaves
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int col = 0; col < grid[0].length; col++) {
            if (!visited[0][col] && grid[0][col] == 1) {
                dfs(grid, visited, 0, col);
            }
            int row = grid.length - 1;
            if (!visited[row][col] && grid[row][col] == 1) {
                dfs(grid, visited, row, col);
            }
        }

        for (int row = 0; row < grid.length; row++) {
            if (!visited[row][0] && grid[row][0] == 1) {
                dfs(grid, visited, row, 0);
            }
            int col = grid[0].length - 1;
            if (!visited[row][col] && grid[row][col] == 1) {
                dfs(grid, visited, row, col);
            }
        }

        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int[][] arr, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        if (row - 1 >= 0 && arr[row - 1][col] == 1 && !visited[row - 1][col])
            dfs(arr, visited, row - 1, col);

        if (row + 1 < arr.length && arr[row + 1][col] == 1 && !visited[row + 1][col])
            dfs(arr, visited, row + 1, col);

        if (col - 1 >= 0 && arr[row][col - 1] == 1 && !visited[row][col - 1])
            dfs(arr, visited, row, col - 1);

        if (col + 1 < arr[0].length && arr[row][col + 1] == 1 && !visited[row][col + 1])
            dfs(arr, visited, row, col + 1);
    }
}
