package Trees;

// LC - 101
// https://leetcode.com/problems/symmetric-tree
public class SymmetricTrees {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;

        return left.val == right.val && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }
}
