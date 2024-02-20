package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// LC - 994
// https://leetcode.com/problems/rotting-oranges
public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(new RottenOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        Queue<PairClass> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int time = 0;
        boolean containsFresh = false;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new PairClass(row, col));
                    visited[row][col] = true;
                } else if (grid[row][col] == 1)
                    containsFresh = true;
            }
        }

        if (queue.isEmpty())
            if (containsFresh)
                return -1;
            else
                return 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                PairClass pair = queue.poll();
                checkAllDirectionsAndAdd(pair.row, pair.col, visited, queue, grid);
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return time - 1;
    }

    private void checkAllDirectionsAndAdd(int row, int col, boolean[][] visited, Queue<PairClass> queue, int[][] arr) {
        if (row - 1 >= 0 && arr[row - 1][col] == 1 && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            arr[row - 1][col] = 2;
            queue.add(new PairClass(row - 1, col));
        }

        if (row + 1 < arr.length && arr[row + 1][col] == 1 && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            arr[row + 1][col] = 2;
            queue.add(new PairClass(row + 1, col));
        }

        if (col - 1 >= 0 && arr[row][col - 1] == 1 && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            arr[row][col - 1] = 2;
            queue.add(new PairClass(row, col - 1));
        }

        if (col + 1 < arr[0].length && arr[row][col + 1] == 1 && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            arr[row][col + 1] = 2;
            queue.add(new PairClass(row, col + 1));
        }
    }

    private class PairClass {
        int row;
        int col;

        PairClass(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
