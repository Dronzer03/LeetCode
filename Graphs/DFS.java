package Graphs;

import java.util.ArrayList;

// GFG
// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class DFS {
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        visited[0] = true;
        ArrayList<Integer> result = new ArrayList<>();
        dfsGraph(0, result, visited, adj);
        return result;
    }

    private void dfsGraph(int index, ArrayList<Integer> result, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        result.add(index);
        ArrayList<Integer> curr = adj.get(index);
        for (int n : curr) {
            if (!visited[n]) {
                visited[n] = true;
                dfsGraph(n, result, visited, adj);
            }
        }
    }
}
