package Graphs;

import java.util.ArrayList;
import java.util.Stack;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/topological-sorting_973003
// GFG
// https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
    public static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < v; index++) {
            if (!visited[index])
                traverseDfs(adj, index, stack, visited);
        }

        int[] result = new int[v];
        int i = 0;
        while (!stack.isEmpty())
            result[i++] = stack.pop();
        return result;
    }

    private static void traverseDfs(ArrayList<ArrayList<Integer>> adj, int index, Stack<Integer> result, boolean[] visited) {
        visited[index] = true;

        for (int node : adj.get(index)) {
            if (!visited[node])
                traverseDfs(adj, node, result, visited);
        }
        result.push(index);
    }
}
