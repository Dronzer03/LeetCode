package BinarySearch;

// LC - 74
// https://leetcode.com/problems/search-a-2d-matrix
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1}, {3}};
        new SearchMatrix().searchMatrix(matrix, 2);
    }

    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        //apply binary search:
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
            return false;
        int row = searchRow(matrix, target, 0, matrix.length - 1);
        return isPresentInRow(matrix[row], target, 0, matrix[row].length);
    }

    private boolean isPresentInRow(int[] row, int target, int start, int end) {
        if (start > end || start >= row.length)
            return false;

        int mid = (start + end) / 2;

        if (row[mid] == target)
            return true;

        if (target > row[mid])
            return isPresentInRow(row, target, mid + 1, end);
        return isPresentInRow(row, target, start, mid - 1);
    }

    private int searchRow(int[][] matrix, int target, int start, int end) {
        int mid = (end + start) / 2;

        if (target >= matrix[mid][0] && (mid == matrix.length - 1 || matrix[mid + 1][0] > target))
            return mid;

        if (target > matrix[mid][0])
            return searchRow(matrix, target, mid + 1, end);
        return searchRow(matrix, target, start, mid - 1);
    }
}
