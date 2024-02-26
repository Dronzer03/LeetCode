package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// LC - 1091
// https://leetcode.com/problems/shortest-path-in-binary-matrix
public class PathInBinaryMaze {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        Queue<Pair> queue = new LinkedList<>();
        int[][] dist = new int[grid.length][grid.length];
        for (int i=0; i<grid.length; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }

        queue.offer(new Pair(0, 0));
        int distance = 0;
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int index = 0; index < size; index++) {
                Pair node = queue.poll();
                if (node.row == grid.length - 1 && node.col == grid.length - 1)
                    return distance;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (node.row + i >= 0 && node.row + i < grid.length && node.col + j >= 0 && node.col + j < grid.length
                                && grid[node.row + i][node.col + j] == 0) {
                            if (1 + distance < dist[node.row + i][node.col + j]) {
                                dist[node.row + i][node.col + j] = 1 + distance;
                                queue.offer(new Pair(node.row + i, node.col + j));
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    private class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},{0,1,0},{0,0,0}
        };
        System.out.println(new PathInBinaryMaze().shortestPathBinaryMatrix(grid));
    }
}
