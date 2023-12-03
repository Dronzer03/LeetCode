package Recursion;

public class NQueens {
    public int nQueens(boolean[][] board, int column, int count) {
        if (column == board.length) {
            return (count + 1);
        }

        for (int i = 0; i < board.length; i++) {
            if (canPlace(board, i, column)) {
                board[i][column] = true;
                count = nQueens(board, column + 1, count);
                board[i][column] = false;
            }
        }
        return count;
    }

    public boolean canPlace(boolean[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col])
                return false;
            row--;
            col--;
        }

        col = dupCol;
        row = dupRow;

        while (col >= 0) {
            if (board[row][col])
                return false;
            col--;
        }

        row = dupRow;
        col = dupCol;

        while (row < board.length && col >= 0) {
            if (board[row][col])
                return false;
            row++;
            col--;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(0, board, res);
        return res;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        boolean[][] board = new boolean[4][4];
        System.out.println(nQueens.nQueens(board, 0, 0));
    }
}
