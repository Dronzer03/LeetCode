package Arrays.Matrix;

import java.util.Arrays;

// LC - 73
// https://leetcode.com/problems/set-matrix-zeroes
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {

        boolean row0 = false, col0 = false;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                col0 = true;
                break;
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                row0 = true;
                break;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (row0) {
            Arrays.fill(matrix[0], 0);
        }

        if (col0) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
