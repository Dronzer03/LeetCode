package Trees;

import java.util.*;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/time-to-burn-tree_630563
public class TimeToBurnTheTree {
    public int minTimeToBurn(TreeNode root, int target) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        queue.offer(root);
        TreeNode targetNode = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == target)
                    targetNode = node;
                if (node.left != null) {
                    queue.offer(node.left);
                    parent.put(node.left, node);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    parent.put(node.right, node);
                }
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        return findNodes(targetNode, 0, parent, visited) - 1;
    }

    private int findNodes(TreeNode target, int k, Map<TreeNode, TreeNode> parent, Set<TreeNode> visited) {
        if (target == null || visited.contains(target))
            return k;

        visited.add(target);

        int left = findNodes(target.left, k + 1, parent, visited);
        int right = findNodes(target.right, k + 1, parent, visited);
        int parentDist = findNodes(parent.getOrDefault(target, null), k + 1, parent, visited);

        return Math.max(parentDist, Math.max(left, right));
    }
}
