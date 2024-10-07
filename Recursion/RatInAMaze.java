package Recursion;

import java.util.ArrayList;
import java.util.Collections;

// GFG
// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInAMaze {
    // Use StringBuilder instead of String
    // findAllPaths and findValidOptions can be combined
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> result = findAllPaths(m, n, new ArrayList<>(), 0, 0, "");
        Collections.sort(result);
        return result;
    }

    private static ArrayList<String> findAllPaths(int[][] m, int n, ArrayList<String> path, int row, int col, String curr) {
        if (row == n - 1 && col == n - 1 && m[row][col] == 1) {
            path.add(curr);
            return path;
        }

        m[row][col] = 0;
        ArrayList<String> validOptions = getAllValidOptions(m, row, col);
        if (validOptions.isEmpty())
            return path;

        for (String s : validOptions) {
            curr += s;
            if (s.equals("D")) {
                findAllPaths(m, n, path, row + 1, col, curr);
                m[row + 1][col] = 1;
            } else if (s.equals("R")) {
                findAllPaths(m, n, path, row, col + 1, curr);
                m[row][col + 1] = 1;
            } else if (s.equals("U")) {
                findAllPaths(m, n, path, row, col - 1, curr);
                m[row][col - 1] = 1;
            } else {
                findAllPaths(m, n, path, row - 1, col, curr);
                m[row - 1][col] = 1;
            }
            curr = curr.substring(0, curr.length() - 1);
        }
        return path;
    }

    private static ArrayList<String> getAllValidOptions(int[][] m, int row, int col) {
        ArrayList<String> result = new ArrayList<>();
        if (row + 1 < m.length && m[row + 1][col] == 1) {
            result.add("D");
        }
        if (col + 1 < m.length && m[row][col + 1] == 1) {
            result.add("R");
        }
        if (col - 1 > 0 && m[row][col - 1] == 1) {
            result.add("L");
        }
        if (row - 1 > 0 && m[row - 1][col] == 1) {
            result.add("U");
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        int[][] m1 = {{1, 0},
                {1, 0}};
        int n = 4;
        System.out.println(findPath(m, 4));
    }

    public static ArrayList<String> findPathOptimal(int[][] m, int n) {
        int[][] vis = new int[n][n];
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 1) solve(0, 0, m, n, ans, "", vis);
        return ans;
    }

    private static void solve(int i, int j, int[][] a, int n, ArrayList<String> ans, String move,
                              int[][] vis) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // downward
        if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
            vis[i][j] = 1;
            solve(i + 1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
            vis[i][j] = 1;
            solve(i, j - 1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }

        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
            vis[i][j] = 1;
            solve(i, j + 1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }

        // upward
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
            vis[i][j] = 1;
            solve(i - 1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }

}
