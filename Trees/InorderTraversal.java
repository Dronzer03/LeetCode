package Trees;

import java.util.ArrayList;
import java.util.List;

// LC - 94
// https://leetcode.com/problems/binary-tree-inorder-traversal
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        return traverse(root, new ArrayList<>());
    }

    public List<Integer> traverse(TreeNode root, List<Integer> result) {
        if (root == null)
            return result;

        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);

        return result;
    }
}
