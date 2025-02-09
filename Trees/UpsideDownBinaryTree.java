package Trees;

public class UpsideDownBinaryTree {
    public TreeNode upsideDown(TreeNode root) {
        if (root == null || root.left == null)
            return root;

        TreeNode newRoot = upsideDown(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.right = null;
        root.left = null;
        return newRoot;
    }
}
