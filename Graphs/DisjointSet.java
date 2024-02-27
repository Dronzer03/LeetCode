package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node))
            return node;
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);
        if (ultimateParentU == ultimateParentV)
            return;
        if (rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
        } else if (rank.get(ultimateParentV) < rank.get(ultimateParentU)) {
            parent.set(ultimateParentV, ultimateParentU);
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            int rankU = rank.get(ultimateParentU);
            rank.set(ultimateParentU, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);
        if (ultimateParentU == ultimateParentV)
            return;
        if (size.get(ultimateParentU) < size.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentV) + size.get(ultimateParentU));
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentV) + size.get(ultimateParentU));
        }
    }
}
