package Graphs;

import java.util.*;

// GFG
// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
public class ShortestPathInUndirectedGraph {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n];
        Arrays.fill(result, (int) (1e9));

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        result[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int index : adj.get(node)) {
                if (1 + result[node] < result[index]) {
                    result[index] = 1 + result[node];
                    queue.offer(index);
                }
            }
        }

        for (int index = 0; index < n; index++) {
            if (result[index] == 1e9)
                result[index] = -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        System.out.println(Arrays.toString(new ShortestPathInUndirectedGraph().shortestPath(edge, n, m, 0)));
    }
}
