package Trees;

import java.util.ArrayList;
import java.util.List;

// LC - 144
// https://leetcode.com/problems/binary-tree-preorder-traversal
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        return traverse(root, new ArrayList<>());
    }

    private  List<Integer> traverse(TreeNode root, List<Integer> result) {
        if (root == null)
            return result;

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);

        return result;
    }
}
