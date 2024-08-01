package Graphs;

// Find number of Distinct Island which are connected 8-Directionally
// GFG
// https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
// LC - 200
// https://leetcode.com/problems/number-of-islands
public class NumberOfIslands {
    public static int distinctIsland(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        int islands = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (arr[row][col] == '1') {
                    islands++;
                    traverseGraph(arr, visited, row, col, n, m);
                }
            }
        }
        return islands;
    }

    private static void traverseGraph(char[][] arr, boolean[][] visited, int row, int col, int n, int m) {
        visited[row][col] = true;

        for (int newRow = -1; newRow <= 1; newRow++) {
            for (int newCol = -1; newCol <= 1; newCol++) {
                int i = row + newRow;
                int j = col + newCol;
                if (i >= 0 && i < n && j >= 0 && j < m
                        && arr[i][j] == '1' && !visited[i][j]) {
                    traverseGraph(arr, visited, i, j, n, m);
                }
            }
        }
    }

    private static void traverseGraphFourDirectional(char[][] arr, boolean[][] visited, int row, int col, int n, int m) {
        visited[row][col] = true;

        if (row - 1 >= 0 && arr[row - 1][col] == '1' && !visited[row - 1][col])
            traverseGraph(arr, visited, row - 1, col, n, m);

        if (row + 1 < n && arr[row + 1][col] == '1' && !visited[row + 1][col])
            traverseGraph(arr, visited, row + 1, col, n, m);

        if (col - 1 >= 0 && arr[row][col - 1] == '1' && !visited[row][col - 1])
            traverseGraph(arr, visited, row, col - 1, n, m);

        if (col + 1 < m && arr[row][col + 1] == '1' && !visited[row][col + 1])
            traverseGraph(arr, visited, row, col + 1, n, m);
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(distinctIsland(arr));
    }
}
