package Trees;

// LC - 114
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list
public class FlattenTreeIntoLL {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
