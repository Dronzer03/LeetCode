package Recursion;

// LC - 79
// https://leetcode.com/problems/word-searc
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && findWord(i, j, board, word)) return true;
            }
        }
        return false;
    }

    private static boolean findWord(int i, int j, char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[i][j] = true;
        return wordSearch(1, i, j, board, word, visited);
    }

    private static boolean wordSearch(int index, int i, int j, char[][] board, String word, boolean[][] visited) {
        if (index == word.length())
            return true;

        char ch = word.charAt(index);

        if (i + 1 < board.length && !visited[i + 1][j] && board[i + 1][j] == ch) {
            visited[i + 1][j] = true;
            if (wordSearch(index + 1, i + 1, j, board, word, visited))
                return true;
            visited[i + 1][j] = false;
        }

        if (j + 1 < board[0].length && !visited[i][j + 1] && board[i][j + 1] == ch) {
            visited[i][j + 1] = true;
            if (wordSearch(index + 1, i, j + 1, board, word, visited))
                return true;
            visited[i][j + 1] = false;
        }

        if (i - 1 >= 0 && !visited[i - 1][j] && board[i - 1][j] == ch) {
            visited[i - 1][j] = true;
            if (wordSearch(index + 1, i - 1, j, board, word, visited))
                return true;
            visited[i - 1][j] = false;
        }

        if (j - 1 >= 0 && !visited[i][j - 1] && board[i][j - 1] == ch) {
            visited[i][j - 1] = true;
            if (wordSearch(index + 1, i, j - 1, board, word, visited))
                return true;
            visited[i][j - 1] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ESEECS";
        System.out.println(exist(board, word));
    }
}
