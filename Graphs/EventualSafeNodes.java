package Graphs;

import java.util.ArrayList;
import java.util.List;

// LC - 802
// https://leetcode.com/problems/find-eventual-safe-states
public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        int[] check = new int[graph.length];
        List<Integer> safeNodes = new ArrayList<>();

        for (int index = 0; index < graph.length; index++) {
            if (!visited[index]) {
                dfs(graph, visited, pathVisited, index, check);
            }
        }

        for (int index = 0; index < graph.length; index++)
            if (check[index] == 1)
                safeNodes.add(index);

        return safeNodes;
    }

    private static boolean dfs(int[][] adj, boolean[] visited, boolean[] recursion, int index, int[] check) {
        visited[index] = true;
        recursion[index] = true;
        check[index] = 0;

        int[] current = adj[index];

        for (int node : current) {
            if (recursion[node])
                return true;

            if (!visited[node] && dfs(adj, visited, recursion, node, check))
                return true;
        }

        check[index] = 1;
        recursion[index] = false;
        return false;
    }
}
