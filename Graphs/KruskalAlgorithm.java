package Graphs;

import java.util.Arrays;
import java.util.Comparator;

// GFG
// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class KruskalAlgorithm {
    public int spanningTree(int V, int E, int edges[][]) {
        Arrays.sort(edges, Comparator.comparingInt(x -> x[2]));

        int weight = 0;
        DisjointSet disjointSet = new DisjointSet(V);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (disjointSet.findParent(u) != disjointSet.findParent(v)) {
                weight += wt;
                disjointSet.unionBySize(edge[0], edge[1]);
            }
        }

        return weight;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };
        System.out.println(new KruskalAlgorithm().spanningTree(3, 3, edges));
    }
}
