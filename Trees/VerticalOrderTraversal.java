package Trees;

import java.util.*;

// LC - 987
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        traverseVertical(root, map, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, PriorityQueue<Integer>> currMap = entry.getValue();
            List<Integer> subList = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> insideEntry : currMap.entrySet()) {
                PriorityQueue<Integer> pq = insideEntry.getValue();
                while (!pq.isEmpty())
                    subList.add(pq.poll());
            }
            result.add(subList);
        }
        return result;
    }

    private void traverseVertical(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int x, int y) {
        if (root == null)
            return;

        traverseVertical(root.left, map, x + 1, y - 1);
        TreeMap<Integer, PriorityQueue<Integer>> currMap = map.get(y);
        PriorityQueue<Integer> pq;
        if (Objects.isNull(currMap)) {
            currMap = new TreeMap<>();
        }
        pq = currMap.get(x);
        if (Objects.isNull(pq))
            pq = new PriorityQueue<>();
        pq.add(root.val);
        currMap.put(x, pq);
        map.put(y, currMap);
        traverseVertical(root.right, map, x + 1, y + 1);
    }
}
