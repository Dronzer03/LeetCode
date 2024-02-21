package Graphs;

// LC - 130
// https://leetcode.com/problems/surrounded-regions
public class SurroundedRegions {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int col = 0; col < board[0].length; col++) {
            if (!visited[0][col] && board[0][col] == 'O') {
                dfs(board, visited, 0, col);
            }
            int row = board.length - 1;
            if (!visited[row][col] && board[row][col] == 'O') {
                dfs(board, visited, row, col);
            }
        }

        for (int row = 0; row < board.length; row++) {
            if (!visited[row][0] && board[row][0] == 'O') {
                dfs(board, visited, row, 0);
            }
            int col = board[0].length - 1;
            if (!visited[row][col] && board[row][col] == 'O') {
                dfs(board, visited, row, col);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (!visited[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] arr, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        if (row - 1 >= 0 && arr[row - 1][col] == 'O' && !visited[row - 1][col])
            dfs(arr, visited, row - 1, col);

        if (row + 1 < arr.length && arr[row + 1][col] == 'O' && !visited[row + 1][col])
            dfs(arr, visited, row + 1, col);

        if (col - 1 >= 0 && arr[row][col - 1] == 'O' && !visited[row][col - 1])
            dfs(arr, visited, row, col - 1);

        if (col + 1 < arr[0].length && arr[row][col + 1] == 'O' && !visited[row][col + 1])
            dfs(arr, visited, row, col + 1);
    }
}
