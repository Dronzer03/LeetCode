package Arrays.Matrix;

// LC - 251
// https://leetcode.com/problems/flatten-2d-vector
public class Flatten2DVector {

    int[][] matrix;
    int row;
    int col;

    Flatten2DVector(int[][] matrix) {
        this.matrix = matrix;
        row = 0;
        col = 0;
    }

    public boolean hasNext() {
        if (row == matrix.length)
            return false;
        if (col < matrix[row].length)
            return true;
        col = 0;
        row++;
        while (row < matrix.length && col == matrix[row].length)
            row++;
        return row < matrix.length;
    }

    public int next() {
        if (hasNext()) {
            return matrix[row][col++];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] vector = new int[][]{{1, 2},{3},{},{4}};
        Flatten2DVector obj = new Flatten2DVector(vector);
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
}
