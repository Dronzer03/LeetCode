package Graphs;

import java.util.ArrayList;

public class DetectCycleUndirectedGraphDFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int index = 0; index < V; index++) {
            if (!visited[index]) {
                if (detectCycle(adj, visited, index, -1))
                    return true;
            }
        }
        return false;
    }

    private boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int index, int source) {
        visited[index] = true;

        ArrayList<Integer> adjList = adj.get(index);

        for (int n : adjList) {
            if (n != source && visited[n])
                return true;
            if (n != source && detectCycle(adj, visited, n, index))
                return true;
        }
        return false;
    }
}
