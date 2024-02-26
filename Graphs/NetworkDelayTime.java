package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// LC - 743
// https://leetcode.com/problems/network-delay-time
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(Comparator.comparingInt(x -> x.time));
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int) 1e9);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : times) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        dist[k] = 0;
        queue.offer(new Pair(k, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int time = current.time;
            for (Pair pair : adj.get(node)) {
                int nextNode = pair.node;
                int nextTime = pair.time;
                if (time + nextTime < dist[nextNode]) {
                    dist[nextNode] = time + nextTime;
                    queue.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int index = 1; index <= n ; index++) {
            if (dist[index] == 1e9)
                return -1;
            max = Math.max(max, dist[index]);
        }
        return max;
    }

    private class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}
