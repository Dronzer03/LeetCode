package Trees;

// LC - 98
// https://leetcode.com/problems/validate-binary-search-tree
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.val >= max || root.val <= min)
            return false;

        return checkValidBST(root.left, min, root.val) && checkValidBST(root.right, root.val, max);
    }
}
