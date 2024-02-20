package Graphs;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        traverseDfs(adj, 0, result, visited);
        return result;
    }

    private void traverseDfs(ArrayList<ArrayList<Integer>> adj, int index, ArrayList<Integer> result, boolean[] visited) {
        if (visited[index])
            return;

        visited[index] = true;
        result.add(index);
        ArrayList<Integer> currList = adj.get(index);
        for (int i=0; i<currList.size(); i++) {
            traverseDfs(adj, currList.get(i), result, visited);
        }
    }
}
