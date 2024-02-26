package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// GFG
// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class MinimumSpanningTree {
    public static int spanningTree(int V, int E, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        queue.offer(new Pair(0, 0));
        boolean[] visited = new boolean[V];

        int sum = 0;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (!visited[current.node]) {
                sum += current.distance;
                int node = current.node;
                visited[node] = true;
                for (Pair pair : adj.get(node)) {
                    queue.offer(new Pair(pair.node, pair.distance));
                }
            }
        }

        return sum;
    }

    private static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
