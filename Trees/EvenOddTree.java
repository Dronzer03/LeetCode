package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean even = level % 2 == 0;
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int index = 0; index < size; index++) {
                TreeNode node = queue.poll();
                if (even && (node.val <= prev || node.val % 2 == 0)) {
                    return false;
                } else if (!even && (node.val >= prev || node.val % 2 == 1)) {
                    return false;
                }
                prev = node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            level++;
        }

        return true;
    }
}
