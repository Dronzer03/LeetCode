package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// GFG
// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class DistinctIslands {
    int countDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<ArrayList<Integer>> set = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    ArrayList<Integer> visitedList = new ArrayList<>();
                    dfs(grid, visited, visitedList, row, col, row, col);
                    set.add(visitedList);
                }
            }
        }

        return set.size();
    }

    private void dfs(int[][] arr, boolean[][] visited, ArrayList<Integer> visitedList, int row, int col, int baseRow, int baseCol) {
        visited[row][col] = true;
        visitedList.add(row - baseRow);
        visitedList.add(col - baseCol);

        if (row - 1 >= 0 && arr[row - 1][col] == 1 && !visited[row - 1][col])
            dfs(arr, visited, visitedList, row - 1, col, baseRow, baseCol);

        if (row + 1 < arr.length && arr[row + 1][col] == 1 && !visited[row + 1][col])
            dfs(arr, visited, visitedList, row + 1, col, baseRow, baseCol);

        if (col - 1 >= 0 && arr[row][col - 1] == 1 && !visited[row][col - 1])
            dfs(arr, visited, visitedList, row, col - 1, baseRow, baseCol);

        if (col + 1 < arr[0].length && arr[row][col + 1] == 1 && !visited[row][col + 1])
            dfs(arr, visited, visitedList, row, col + 1, baseRow, baseCol);
    }

    int countDistinctIslandsOtherWay(int[][] grid) {
        // Your Code here
        Set<String> islands = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfsGraph(row, col, row, col, sb, grid);
                    islands.add(sb.toString());
                }
            }
        }

        return islands.size();
    }

    private void dfsGraph(int row, int col, int sourceRow, int sourceCol, StringBuilder sb, int[][] grid) {
        sb.append(String.valueOf(row - sourceRow));
        sb.append(String.valueOf(col - sourceCol));
        sb.append("#");

        grid[row][col] = 0;

        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            dfsGraph(row + 1, col, sourceRow, sourceCol, sb, grid);
        }
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            dfsGraph(row - 1, col, sourceRow, sourceCol, sb, grid);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
            dfsGraph(row, col + 1, sourceRow, sourceCol, sb, grid);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            dfsGraph(row, col - 1, sourceRow, sourceCol, sb, grid);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(new DistinctIslands().countDistinctIslands(grid));
    }
}
