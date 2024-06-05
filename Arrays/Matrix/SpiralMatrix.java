package Arrays.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0, right = cols;
        int top = 0, bottom = rows;

        List<Integer> result = new ArrayList<>();

        while (left < right && top < bottom) {
            for (int i = left; i < right ; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right-1]);
            }
            right--;

            if (!(left < right && top < bottom)) {
                break;
            }

            for (int i=right-1; i >= left; i-- ) {
                result.add(matrix[bottom-1][i]);
            }
            bottom--;

            for (int i=bottom-1; i>=top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
