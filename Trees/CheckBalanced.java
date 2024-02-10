package Trees;

// LC - 110
// https://leetcode.com/problems/balanced-binary-tree
public class CheckBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return findHeight(root) == -1 ? false : true;
    }

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
}
