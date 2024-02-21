package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// LC - 542
// https://leetcode.com/problems/01-matrix
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<PairClass> queue = new LinkedList<>();

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    queue.offer(new PairClass(row, col));
                    visited[row][col] = true;
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int index = 0; index < size; index++) {
                PairClass pair = queue.poll();
                int row = pair.row;
                int col = pair.col;
                checkAndUpdateDist(mat, row, col, dist, visited, queue);
            }
        }

        return mat;
    }

    private void checkAndUpdateDist(int[][] mat, int row, int col, int dist, boolean[][] visited, Queue<PairClass> queue) {
        if (row - 1 >= 0 && !visited[row - 1][col] && mat[row - 1][col] != 0) {
            visited[row - 1][col] = true;
            queue.offer(new PairClass(row - 1, col));
            mat[row - 1][col] = dist;
        }

        if (row + 1 < mat.length && !visited[row + 1][col] && mat[row + 1][col] != 0) {
            visited[row + 1][col] = true;
            queue.offer(new PairClass(row + 1, col));
            mat[row + 1][col] = dist;
        }

        if (col - 1 >= 0 && !visited[row][col - 1] && mat[row][col - 1] != 0) {
            visited[row][col - 1] = true;
            queue.offer(new PairClass(row, col - 1));
            mat[row][col - 1] = dist;
        }

        if (col + 1 < mat[0].length && !visited[row][col + 1] && mat[row][col + 1] != 0) {
            visited[row][col + 1] = true;
            queue.offer(new PairClass(row, col + 1));
            mat[row][col + 1] = dist;
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
