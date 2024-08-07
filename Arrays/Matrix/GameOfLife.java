package Arrays.Matrix;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                updateCurrent(board, row, col);
            }
        }
        makeThemAlive(board);
    }

    private void makeThemAlive(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 2)
                    board[row][col] = 0;

                if (board[row][col] == 3)
                    board[row][col] = 1;
            }
        }
    }

    private void updateCurrent(int[][] board, int row, int col) {
        int sum = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (row + r < 0 || row + r >= board.length || col + c < 0 || col + c >= board[0].length || (r == 0 && c == 0))
                    continue;

                if (board[row + r][col + c] == 0 || board[row + r][col + c] == 3)
                    continue;

                sum++;
            }
        }

        if (board[row][col] == 1 && (sum < 2 || sum > 3))
            board[row][col] = 2;

        if (board[row][col] == 0 && sum == 3)
            board[row][col] = 3;
    }
}
