package Trees;

// LC - 450
// https://leetcode.com/problems/delete-node-in-a-bst
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (root.val == key)
            return deleteCurrentNode(root);

        TreeNode node = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = deleteCurrentNode(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = deleteCurrentNode(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return node;
    }

    private TreeNode deleteCurrentNode(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode right = root.right;
            TreeNode lastRight = root.left;
            while (lastRight.right != null)
                lastRight = lastRight.right;
            lastRight.right = right;
            return root.left;
        }
    }
}
