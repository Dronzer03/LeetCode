package Trees;

import java.util.LinkedList;
import java.util.Queue;

// LC - 513
// https://leetcode.com/problems/find-bottom-left-tree-value
public class BottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int result = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                TreeNode node = queue.poll();
                if (index == 0)
                    result = node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return result;
    }
}
