package Graphs;

import java.util.*;

// Working Solution but TLE
// Come back to this when you do Dijkstra's Algorithm
// LC - 787
// https://leetcode.com/problems/cheapest-flights-within-k-stops
public class CheapestFlightWithKStops {
    int cheapest = (int) 1e9;

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        System.out.println(new CheapestFlightWithKStops().findCheapestPriceBFS(5, flights, 0, 2, 2));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<PairClass>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new PairClass(flight[1], flight[2]));
        }

        dfs(src, k, 0, adj, dst);

        if (cheapest == 1e9)
            return -1;
        return cheapest;
    }

    private void dfs(int src, int k, int cost, List<List<PairClass>> adj, int dst) {
        for (PairClass pair : adj.get(src)) {
            int node = pair.node;
            if (node == dst && k >= 0) {
                cheapest = Math.min(cheapest, cost + pair.weight);
            }
            if (node != dst && k > 0 && cost + pair.weight < cheapest)
                dfs(node, k - 1, cost + pair.weight, adj, dst);
        }
    }

    // This works
    // GG
    public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int k) {
        List<List<PairClass>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new PairClass(flight[1], flight[2]));
        }

        Queue<PairClass> queue = new LinkedList<>();
        queue.offer(new PairClass(src, 0));
        int stops = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                PairClass pair = queue.poll();
                for (PairClass pairClass : adj.get(pair.node)) {
                    if (pair.weight + pairClass.weight >= dist[pairClass.node])
                        continue;
                    dist[pairClass.node] = pair.weight + pairClass.weight;
                    queue.offer(new PairClass(pairClass.node, dist[pairClass.node]));
                }
            }
            stops++;
        }

        return dist[dst] == 1e9 ? -1 : dist[dst];
    }

    class PairClass {
        int node;
        int weight;

        PairClass(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
