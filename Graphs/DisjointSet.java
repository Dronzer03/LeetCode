package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    int[] parent;
    int[] rank;
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);
        if (ultimateParentU == ultimateParentV)
            return;
        if (rank[ultimateParentU] < rank[ultimateParentV]) {
            parent[ultimateParentU] = ultimateParentV;
        } else if (rank[ultimateParentU] > rank[ultimateParentV]) {
            parent[ultimateParentV] = ultimateParentU;
        } else {
            parent[ultimateParentV] = ultimateParentU;
            rank[ultimateParentU]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);
        if (ultimateParentU == ultimateParentV)
            return;
        if (size.get(ultimateParentU) < size.get(ultimateParentV)) {
            parent[ultimateParentU] = ultimateParentV;
            size.set(ultimateParentV, size.get(ultimateParentV) + size.get(ultimateParentU));
        } else {
            parent[ultimateParentV] = ultimateParentU;
            size.set(ultimateParentU, size.get(ultimateParentV) + size.get(ultimateParentU));
        }
    }
}
