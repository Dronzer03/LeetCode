package Trees;

import java.util.*;

// LC - 662
// https://leetcode.com/problems/maximum-width-of-binary-tree
public class MaximumWidthOfTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for (int index = 0; index < size; index++) {
                TreeNode current = queue.poll();
                if (index == 0)
                    start = current.val;

                if (index == size - 1)
                    end = current.val;

                if (current.left != null) {
                    current.left.val = current.val * 2;
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    current.right.val = current.val * 2 + 1;
                    queue.offer(current.right);
                }
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }
}
