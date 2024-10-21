package Graphs;

import java.util.ArrayList;
import java.util.Stack;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/topological-sorting_973003
// GFG
// https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < adj.size(); index++) {
            if (!visited[index]) {
                dfsGraph(index, adj, stack, visited);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static void dfsGraph(int index, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
        visited[index] = true;

        for (int node : adj.get(index)) {
            if (!visited[node]) {
                dfsGraph(node, adj, stack, visited);
            }
        }

        stack.push(index);
    }
}
