package StringsAndArrays.Matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> validRow;
        Set<Character> validCol;
        for (int i = 0; i < board.length; i++) {
            validRow = new HashSet<>();
            validCol = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (validRow.contains(board[i][j]))
                        return false;
                    validRow.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (validCol.contains(board[j][i]))
                        return false;
                    validCol.add(board[j][i]);
                }
            }
        }
        return checkInnerMatrices(board);
    }

    private boolean checkInnerMatrices(char[][] board) {
        int i=0, j=0;
        Set<Character> validMatrix;
        while (i<9) {
            validMatrix = new HashSet<>();
            for (int m=i; m<=i+2; m++) {
                for (int n=j; n<=j+2; n++) {
                    if (board[m][n]!='.') {
                        if (validMatrix.contains(board[m][n]))
                            return false;
                        validMatrix.add(board[m][n]);
                    }
                }
            }
            j+=3;
            if (j==9) {
                j=0;
                i+=3;
            }
        }
        return true;
    }

    public boolean isValidSudokuOptimal(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (! seen.add(val + " found in row "+ i)
                    || !seen.add(val + " found in col" + j)
                    || !seen.add(val + "found in box" + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
