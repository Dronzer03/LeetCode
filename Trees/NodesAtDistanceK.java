package Trees;

import java.util.*;

// LC - 863
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree
public class NodesAtDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                TreeNode node = queue.poll();
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

        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        findNodes(target, k, parent, result, visited);
        return result;
    }

    private void findNodes(TreeNode target, int k, Map<TreeNode, TreeNode> parent, List<Integer> result, Set<TreeNode> visited) {
        if (target == null)
            return;

        if (visited.contains(target))
            return;

        if (k == 0) {
            result.add(target.val);
            return;
        }

        visited.add(target);

        findNodes(target.left, k - 1, parent, result, visited);
        findNodes(target.right, k - 1, parent, result, visited);
        findNodes(parent.getOrDefault(target, null), k - 1, parent, result, visited);
    }
}
