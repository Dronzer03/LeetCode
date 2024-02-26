package Graphs;

// GFG
// https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
public class FloydWarshall {
    public void shortest_distance(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)1e9;
                }
                if (i == j)
                    matrix[i][j] = 0;
            }
        }

        for (int via = 0; via < matrix.length; via++) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    matrix[row][col] = Math.min(matrix[row][col], matrix[row][via] + matrix[via][col]);
                }
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if (matrix[i][j] == 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
