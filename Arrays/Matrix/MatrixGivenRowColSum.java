package Arrays.Matrix;

// LC - 1605
// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums
public class MatrixGivenRowColSum {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] res = new int[rows][cols];

        for (int row = 0; row < rows; row++)
            res[row][0] = rowSum[row];

        for (int col = 0; col < cols - 1; col++) {
            long curr_col_sum = 0;
            for (int row = 0; row < rows; row++)
                curr_col_sum += res[row][col];

            int row = 0;
            while (curr_col_sum > colSum[col]) {
                long reduce = curr_col_sum - colSum[col];
                long to_reduce = Math.min(reduce, res[row][col]);
                res[row][col] -= to_reduce;
                res[row][col + 1] += to_reduce;
                curr_col_sum -= to_reduce;
                row++;
            }
        }

        return res;
    }
}
