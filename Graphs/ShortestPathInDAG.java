package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// GFG
// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
public class ShortestPathInDAG {
    class PairClass {
        int node;
        int weight;
        PairClass(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int[] shortestPath(int N,int M, int[][] edges) {
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        List<List<PairClass>> adj = new ArrayList<>();
        for (int index = 0; index < N; index++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new PairClass(edge[1], edge[2]));
        }

        for (int node = 0; node < N; node++) {
            if (!visited[node]) {
                dfs(adj, visited, stack, node);
            }
        }

        int[] result = new int[N];
        Arrays.fill(result, (int)(1e9));
        result[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            int dist = result[node];
            for (PairClass pair : adj.get(node)) {
                result[pair.node] = Math.min(result[pair.node], dist + pair.weight);
            }
        }

        for (int i=0; i< result.length; i++)
            if (result[i] == 1e9)
                result[i] = -1;

        return result;
    }

    private void dfs(List<List<PairClass>> adj, boolean[] visited, Stack<Integer> stack, int node) {
        visited[node] = true;

        for (PairClass pair : adj.get(node)) {
            if (!visited[pair.node]) {
                dfs(adj, visited, stack, pair.node);
            }
        }

        stack.push(node);
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0,1,2},
                {0,2,1}
        };
        System.out.println(Arrays.toString(new ShortestPathInDAG().shortestPath(4, 2, edges)));
    }
}
