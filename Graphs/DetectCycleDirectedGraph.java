package Graphs;

import java.util.ArrayList;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/detect-cycle-in-a-directed-graph-_920545
// GFG
// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class DetectCycleDirectedGraph {
    public static Boolean isCyclic(int[][] edges, int v, int e) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[v];
        boolean[] recursion = new boolean[v];

        for (int index = 0; index < adj.size(); index++) {
            if (!visited[index]) {
                if (dfs(adj, visited, recursion, index))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recursion, int index) {
        visited[index] = true;
        recursion[index] = true;

        ArrayList<Integer> current = adj.get(index);

        for (int node : current) {
            if (recursion[node])
                return true;

            if (!visited[node] && dfs(adj, visited, recursion, node))
                return true;
        }

        recursion[index] = false;
        return false;
    }
}
