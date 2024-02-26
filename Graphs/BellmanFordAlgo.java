package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

// GFG
// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
public class BellmanFordAlgo {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[S] = 0;

        for (int index = 0; index < V - 1; index++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                if (dist[u] != 1e8 && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            if (dist[u] != 1e8 && dist[u] + weight < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }
}
