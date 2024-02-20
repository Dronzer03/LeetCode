package Graphs;

// Find number of Distinct Island which are connected 8-Directionally
// GFG
// https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
public class DistinctIslands {
    public static int distinctIsland(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        int islands = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (arr[row][col] == '1' && !visited[row][col]) {
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

    public static void main(String[] args) {
        char[][] arr = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','1','1'},
                {'0','0','0','1','1'}
        };
        System.out.println(distinctIsland(arr));
    }
}
