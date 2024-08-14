package Arrays.Matrix;

// LC - 885
// https://leetcode.com/problems/spiral-matrix-iii
public class SpiralMatrix3 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int range = 1;
        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;
        int[][] result = new int[rows * cols][2];
        result[0] = new int[] {rStart, cStart};
        int index = 1;

        int current = 0;
        while (index < rows * cols) {
            current++;
            if (right) {
                cStart++;
                if (current == range) {
                    right = false;
                    down = true;
                    current = 0;
                }
            } else if (down) {
                rStart++;
                if (current == range) {
                    down = false;
                    left = true;
                    current = 0;
                    range++;
                }
            } else if (left) {
                cStart--;
                if (current == range) {
                    left = false;
                    up = true;
                    current = 0;
                }
            } else if (up) {
                rStart--;
                if (current == range) {
                    up = false;
                    right = true;
                    current = 0;
                    range++;
                }
            }
            if (rStart < 0 || rStart >= rows || cStart < 0 || cStart >= cols) {
                continue;
            }
            result[index++] = new int[]{rStart, cStart};
        }

        return result;
    }

    public static void main(String[] args) {
        new SpiralMatrix3().spiralMatrixIII(5, 6, 1, 4);
    }
}
