package Trees;

import java.util.ArrayList;
import java.util.List;

// LC - 145
// https://leetcode.com/problems/binary-tree-postorder-traversal
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        return traverse(root, new ArrayList<>());
    }

    public List<Integer> traverse(TreeNode root, List<Integer> result) {
        if (root == null)
            return result;

        traverse(root.left, result);
        traverse(root.right, result);
        result.add(root.val);

        return result;
    }
}
