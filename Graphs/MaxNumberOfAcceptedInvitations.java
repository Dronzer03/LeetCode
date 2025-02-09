package Graphs;

import java.util.Arrays;

public class MaxNumberOfAcceptedInvitations {
    public int maxInvitations(int[][] grid) {
        int[] match = new int[grid.length];
        Arrays.fill(match, -1);

        int invitations = 0;
        for (int index = 0; index < grid.length; index++) {
            if (canInvite(index, grid, match, new boolean[grid.length])) {
                invitations++;
            }
        }
        return invitations;
    }

    private boolean canInvite(int index, int[][] grid, int[] match, boolean[] visited) {
        for (int i = 0; i < grid[index].length; i++) {
            if (visited[i] || grid[index][i] == 0)
                continue;

            visited[i] = true;

            if (match[index] == -1 || canInvite(match[i], grid, match, visited)) {
                match[i] = index;
                return true;
            }
        }

        return false;
    }


}
