package Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// LC - 1631
// https://leetcode.com/problems/path-with-minimum-effort
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        Queue<Tuple> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        int[][] dist = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        int[] moveX = {1, -1, 0, 0};
        int[] moveY = {0, 0, 1, -1};

        queue.offer(new Tuple(0, 0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Tuple node = queue.poll();
            for (int index = 0; index < 4; index++) {
                int row = node.row + moveX[index];
                int col = node.col + moveY[index];
                if (row >= 0 && col >= 0 && row < heights.length && col < heights[0].length) {
                    if (Math.max(dist[node.row][node.col], Math.abs(heights[node.row][node.col] - heights[row][col])) < dist[row][col]) {
                        dist[row][col] = Math.max(dist[node.row][node.col], Math.abs(heights[node.row][node.col] - heights[row][col]));
                        queue.offer(new Tuple(dist[row][col], row, col));
                    }
                }
            }
        }

        return dist[heights.length-1][heights[0].length-1];
    }

    private class Tuple {
        int distance;
        int row;
        int col;

        Tuple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,2,2},{3,8,2},{5,3,5}
        };
    }
}
