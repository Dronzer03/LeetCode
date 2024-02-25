package Graphs;

import java.util.*;

// Dijkstra using PQ
// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
public class DijkstraUsingPQ {
    private static class Pair {
        int distance;
        int node;
        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        queue.offer(new Pair(0, S));
        dist[S] = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int d = pair.distance;
            ArrayList<ArrayList<Integer>> currList = adj.get(pair.node);
            for (int index = 0; index < currList.size(); index++) {
                int currNode = currList.get(index).get(0);
                if ((d + currList.get(index).get(1)) < dist[currNode]) {
                    int newDistance = d + currList.get(index).get(1);
                    dist[currNode] = newDistance;
                    queue.offer(new Pair(newDistance, currNode));
                }
            }
        }

        return dist;
    }
}
