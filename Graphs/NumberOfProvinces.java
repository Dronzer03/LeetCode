package Graphs;

// LC - 547
// https://leetcode.com/problems/number-of-provinces
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;
        for (int index = 0; index < isConnected.length; index++) {
            if (visited[index])
                continue;

            provinces++;
            dfsTraversal(isConnected, visited, index);
        }
        return provinces;
    }

    private void dfsTraversal(int[][] isConnected, boolean[] visited, int index) {
        visited[index] = true;
        int[] adj = isConnected[index];

        for (int node = 0; node < adj.length; node++) {
            if (adj[node] == 1 && !visited[node]) {
                dfsTraversal(isConnected, visited, node);
            }
        }
    }
}
