package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Detect if Cycle is Present in Graph
// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class DetectCycleUndirectedGraph {
    private class PairClass {
        int node;
        int source;
        PairClass(int node, int source) {
            this.node = node;
            this.source = source;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for (int index = 0; index < V; index++) {
            if (!visited[index]) {
                if (detectCycle(adj, visited, index))
                    return true;
            }
        }
        return false;
    }

    private boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int index) {
        visited[index] = true;
        Queue<PairClass> queue = new LinkedList<>();
        queue.offer(new PairClass(index, -1));

        while (!queue.isEmpty()) {
            PairClass pair = queue.poll();
            int node = pair.node;
            int source = pair.source;
            ArrayList<Integer> adjList = adj.get(node);
            for (int n : adjList) {
                if (n != source && visited[n])
                    return true;
                if (n != source) {
                    visited[n] = true;
                    queue.offer(new PairClass(n, node));
                }
            }
        }
        return false;
    }
}
