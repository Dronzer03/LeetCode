package Trees;

import java.util.*;

// LC - 103
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
public class LevelOrderZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZag = new ArrayList<>();
        if (root == null)
            return zigZag;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean left = true;
        while (!queue.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                currList.add(node.val);
            }
            if (left) {
                zigZag.add(currList);
            } else {
                Collections.reverse(currList);
                zigZag.add(currList);
            }
            left = !left;
        }

        return zigZag;
    }
}
