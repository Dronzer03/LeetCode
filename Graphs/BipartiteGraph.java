package Graphs;

// LC - 785
// https://leetcode.com/problems/is-graph-bipartite
public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        Integer[] visited = new Integer[graph.length];

        for (int index = 0; index < graph.length; index++) {
            if (visited[index] == null) {
                if (!dfs(graph, visited, index, 0))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, Integer[] visited, int index, int color) {
        visited[index] = color;

        int[] nodes = graph[index];
        int nextColor = color == 0 ? 1 : 0;
        for (int n : nodes) {
            if (n != index) {
                if (visited[n] != null && visited[n] == color)
                    return false;
                if (visited[n] == null)
                    if (!dfs(graph, visited, n, nextColor))
                        return false;
            }
        }

        return true;
    }
}
