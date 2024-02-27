package Graphs;

// LC - 1319
// https://leetcode.com/problems/number-of-operations-to-make-network-connected
public class MakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        for (int[] connection : connections) {
            int parentFirst = ds.findParent(connection[0]);
            int parentSecond = ds.findParent(connection[1]);
            if (parentFirst == parentSecond) {
                extra++;
            } else {
                ds.unionBySize(connection[0], connection[1]);
            }
        }

        int components = 0;
        for (int i=0; i<n; i++) {
            if (ds.findParent(i) == i)
                components++;
        }

        return components - 1 <= extra ? components - 1 : -1;
    }
}
