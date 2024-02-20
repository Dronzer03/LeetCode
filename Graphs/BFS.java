package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Graph - BFS
// https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            Iterator<Integer> itr = adj.get(node).listIterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n]) {
                    queue.offer(n);
                    visited[n] = true;
                }
            }
        }
        return result;
    }
}
